package com.json;

public class Face {
	private static final String TAG = "JavaTest.Face";
	FacePositions position;
	FaceAttributes attribute;
	String tag;
	String face_id;

	public FacePositions getPosition() {
		return position;
	}

	public void setPosition(FacePositions position) {
		this.position = position;
	}

	public FaceAttributes getAttribute() {
		return attribute;
	}

	public void setAttribute(FaceAttributes attribute) {
		this.attribute = attribute;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getFace_id() {
		return face_id;
	}

	public void setFace_id(String face_id) {
		this.face_id = face_id;
	}

	public class FacePositions {
		Position mouth_right;
		Position mouth_left;
		Position center;
		Position nose;
		Position eye_left;
		Position eye_right;
		float height;
		float width;

		public Position getMouth_right() {
			return mouth_right;
		}

		public void setMouth_right(Position mouth_right) {
			this.mouth_right = mouth_right;
		}

		public Position getMouth_left() {
			return mouth_left;
		}

		public void setMouth_left(Position mouth_left) {
			this.mouth_left = mouth_left;
		}

		public Position getCenter() {
			return center;
		}

		public void setCenter(Position center) {
			this.center = center;
		}

		public Position getNose() {
			return nose;
		}

		public void setNose(Position nose) {
			this.nose = nose;
		}

		public Position getEye_left() {
			return eye_left;
		}

		public void setEye_left(Position eye_left) {
			this.eye_left = eye_left;
		}

		public Position getEye_right() {
			return eye_right;
		}

		public void setEye_right(Position eye_right) {
			this.eye_right = eye_right;
		}

		public float getHeight() {
			return height;
		}

		public void setHeight(float height) {
			this.height = height;
		}

		public float getWidth() {
			return width;
		}

		public void setWidth(float width) {
			this.width = width;
		}
	}

}