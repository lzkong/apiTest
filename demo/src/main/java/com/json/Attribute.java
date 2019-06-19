package com.json;

public class Attribute {
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public float getConfidence() {
		return confidence;
	}

	public void setConfidence(float confidence) {
		this.confidence = confidence;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	String value;
	float confidence;
	int range;
}
