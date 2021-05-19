package study;

public class NonNegativeInteger {

	private static final int ZERO = 0;

	private final int value;

	public NonNegativeInteger(String str) {
		value = Integer.parseInt(str);

		if (isNegativeInteger()) {
			throw new RuntimeException();
		}
	}

	private boolean isNegativeInteger() {
		return value < ZERO;
	}

	public int get() {
		return value;
	}
}
