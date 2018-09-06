
/*
·*byte转换为十进制
 */

public class ByteConvert {
	/*
	 * 高位在前
	 */
	public static int bytesToInt2(byte[] src, int offset, int length) {
		int value = 0;
		if (length == 2) {
			value = (int) (((src[offset] & 0xFF) << 8) | ((src[offset + 1] & 0xFF) << 0));
		} else if (length == 4) {
			value = (int) (((src[offset] & 0xFF) << 24) | ((src[offset + 1] & 0xFF) << 16)
					| ((src[offset + 2] & 0xFF) << 8) | ((src[offset + 3] & 0xFF) << 0));
		}
		return value;
	}

	/*
	 * 高位在后
	 */
	public static int bytesToInt(byte[] src, int offset, int length) {
		int value = 0;
		if (length == 2) {
			value = (int) (((src[offset] & 0xFF) << 0) | ((src[offset + 1] & 0xFF) << 8));
		} else if (length == 4) {
			value = (int) (((src[offset] & 0xFF) << 0) | ((src[offset + 1] & 0xFF) << 8)
					| ((src[offset + 2] & 0xFF) << 16) | ((src[offset + 3] & 0xFF) << 24));
		}
		return value;
	}

	/*
	 * 乱序
	 */
	public static int bytesToInt3(byte[] src, int offset, int length) {
		int value = 0;
		if (length == 2) {
			value = (int) (((src[offset] & 0xFF) << 0) | ((src[offset + 1] & 0xFF) << 8));
		} else if (length == 4) {
			value = (int) (((src[offset + 2] & 0xFF) << 24) | ((src[offset + 3] & 0xFF) << 16)
					| ((src[offset] & 0xFF) << 8) | ((src[offset + 1] & 0xFF) << 0));
		}
		return value;
	}
}
