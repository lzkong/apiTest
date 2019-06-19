package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelUtil {
	private static final Log logger = LogFactory.getLog(ReadExcelUtil.class);
	private final static String xls = "xls";
	private final static String xlsx = "xlsx";

	static String[] readHead = {};

	public static List<Map<String, String>> readExcel(File file, String[] exchead) throws IOException {
		readHead = exchead;
		// 创建返回对象，把每行中的值作为一个数组，所有行作为一个集合返回
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		// 检查文件
		checkFile(file);
		// 获得workbook对象
		Workbook workbook = getWorkBook(file);
		if (workbook != null) {
			for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
				// 获得当前sheet工作表
				Sheet sheet = workbook.getSheetAt(sheetNum);
				if (sheet == null) {
					continue;
				}
				// 获得当前sheet的开始行
				int firstRowNum = sheet.getFirstRowNum() + 1;
				// 获得当前sheet的结束行
				int lastRowNum = sheet.getLastRowNum();
				for (int rowNum = firstRowNum; rowNum <= lastRowNum; rowNum++) {
					// 获得当前行
					Row row = sheet.getRow(rowNum);
					if (row == null) {
						continue;
					}
					// 获得当前行的开始列
					int firstCellNum = row.getFirstCellNum();
					// 获得当前行的列数
					int lastCellNum = row.getLastCellNum();// 为空列获取
//                  int lastCellNum = row.getPhysicalNumberOfCells();//为空列不获取
//                  String[] cells = new String[row.getPhysicalNumberOfCells()];
					// String[] cells = new String[row.getLastCellNum()];
					Map<String, String> cells = new HashMap<String, String>();
					// 循环当前行
					for (int cellNum = firstCellNum; cellNum < lastCellNum; cellNum++) {
						Cell cell = row.getCell(cellNum);
						cells.put(getKey(cellNum), getCellValue(cell));
					}
					list.add(cells);
				}
			}
		}
		return list;

	}

	private static String getKey(int num) {

		String key = readHead[num];

		return key;

	}

	public static String getCellValue(Cell cell) {
		String cellValue = "";
		if (cell == null) {
			return cellValue;
		}
		// 把数字当成String来读，避免出现1读成1.0的情况
		if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
			cell.setCellType(Cell.CELL_TYPE_STRING);
		}
		// 判断数据的类型
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_NUMERIC: // 数字
			cellValue = String.valueOf(cell.getNumericCellValue());
			break;
		case Cell.CELL_TYPE_STRING: // 字符串
			cellValue = String.valueOf(cell.getStringCellValue());
			break;
		case Cell.CELL_TYPE_BOOLEAN: // Boolean
			cellValue = String.valueOf(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_FORMULA: // 公式
//	                cellValue = String.valueOf(cell.getCellFormula());
			cellValue = String.valueOf(cell.getStringCellValue());
			break;
		case Cell.CELL_TYPE_BLANK: // 空值
			cellValue = "";
			break;
		case Cell.CELL_TYPE_ERROR: // 故障
			cellValue = "非法字符";
			break;
		default:
			cellValue = "未知类型";
			break;
		}
		return cellValue;
	}

	public static void checkFile(File file) throws IOException {
		// 判断文件是否存在
		if (null == file) {
			throw new FileNotFoundException("文件不存在！");
		}
		// 获得文件名
		String fileName = file.getName();
		// 判断文件是否是excel文件
		if (!fileName.endsWith(xls) && !fileName.endsWith(xlsx)) {
			throw new IOException(fileName + "不是excel文件");
		}
	}

	public static Workbook getWorkBook(File file) {
		// 获得文件名
		String filename = file.getName();
		Workbook workbook = null;
		try {
			// 获取excel文件的io流
			FileInputStream is = new FileInputStream(file);
			//
			if (filename.endsWith(xls)) {
				// 2003
				workbook = new HSSFWorkbook(is);
			} else {
				// 2207
				workbook = new XSSFWorkbook(is);
			}

		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return workbook;

	}
}
