package com.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.common.parameters.ExcelCommon;

public class ExcelJunitReport {

	private static final String EXCEL_XLS = "xls";
	private static final String EXCEL_XLSX = "xlsx";

	public static void writeExcel(List<Map<String, String>> dataList, int cloumnCount, String finalXlsxPath,
			String sheetName) {
		OutputStream out = null;
		try {
			// 获取总列数
			int columnNumCount = cloumnCount;
			// 读取Excel文档
			File finalXlsxFile = new File(finalXlsxPath);
			if (!finalXlsxFile.exists()) {
				finalXlsxFile.createNewFile();
			}
			Workbook workBook = getWorkbok(finalXlsxFile);
			// sheet 对应一个工作页
			Sheet sheet = workBook.createSheet(sheetName);

			// 创建文件输出流，输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效
			out = new FileOutputStream(finalXlsxPath);
			workBook.write(out);
			/**
			 * 往Excel中写新数据
			 */
			// 写第一行数据
			writeFirstRow(sheet);
			// 写入具体内容
			for (int j = 0; j < dataList.size(); j++) {
				// 创建一行：从第二行开始，跳过属性列
				Row row = sheet.createRow(j + 1);
				// 得到要插入的每一条记录
				Map<String, String> dataMap = dataList.get(j);
				String num = dataMap.get(ExcelCommon.head.num.toString()).toString();
				String url = dataMap.get(ExcelCommon.head.url.toString()).toString();
				String Step = dataMap.get(ExcelCommon.head.Step.toString()).toString();
				String param = dataMap.get(ExcelCommon.head.param.toString()).toString();
				String hopeResult = dataMap.get(ExcelCommon.head.hoperesult.toString()).toString();
				String trueResult = dataMap.get(ExcelCommon.head.trueresult.toString()).toString();
				String message = dataMap.get(ExcelCommon.head.message.toString()).toString();
				for (int k = 0; k <= columnNumCount; k++) {

					// 在一行内循环
					Cell zero = row.createCell(0);
					zero.setCellValue(num);

					Cell first = row.createCell(1);
					first.setCellValue(url);

					Cell second = row.createCell(2);
					second.setCellValue(Step);

					Cell third = row.createCell(3);
					third.setCellValue(param);
					Cell fourth = row.createCell(4);
					fourth.setCellValue(hopeResult);
					Cell five = row.createCell(5);
					five.setCellValue(trueResult);
					Cell six = row.createCell(6);
					six.setCellValue(message);

				}
			}
			// 创建文件输出流，准备输出电子表格：这个必须有，否则你在sheet上做的任何操作都不会有效
			out = new FileOutputStream(finalXlsxPath);
			workBook.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null) {
					out.flush();
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("数据导出成功");
	}

	/**
	 * 判断Excel的版本,获取Workbook
	 * 
	 * @param in
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static Workbook getWorkbok(File file) throws IOException {
		Workbook wb = null;
		if (file.getName().endsWith(EXCEL_XLS)) { // Excel&nbsp;2003
			wb = new HSSFWorkbook();
		} else if (file.getName().endsWith(EXCEL_XLSX)) { // Excel 2007/2010
			wb = new XSSFWorkbook();
		}
		return wb;
	}

	public static void writeFirstRow(Sheet sheet) {

		// 创建一行：从第二行开始，跳过属性列
		Row row = sheet.createRow(0);
		// 得到要插入的每一条记录
		String num = ExcelCommon.headName.编码.toString();
		String url = ExcelCommon.headName.接口.toString();
		String Step = ExcelCommon.headName.步骤.toString();
		String param = ExcelCommon.headName.参数.toString();
		String hopeResult = ExcelCommon.headName.预测结果.toString();
		String trueResult = ExcelCommon.headName.实际结果.toString();
		String message = ExcelCommon.headName.message.toString().toString();

		// 在一行内循环
		Cell zero = row.createCell(0);
		zero.setCellValue(num);

		Cell first = row.createCell(1);
		first.setCellValue(url);

		Cell second = row.createCell(2);
		second.setCellValue(Step);

		Cell third = row.createCell(3);
		third.setCellValue(param);
		Cell fourth = row.createCell(4);
		fourth.setCellValue(hopeResult);
		Cell five = row.createCell(5);
		five.setCellValue(trueResult);
		Cell six = row.createCell(6);
		six.setCellValue(message);
	}
}
