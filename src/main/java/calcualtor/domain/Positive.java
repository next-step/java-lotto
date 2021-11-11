package calcualtor.domain;

public class Positive {
	private final int value;

	Positive(String value) {
		this(Integer.parseInt(value));
	}

	Positive(int value) {
		validate(value);
		this.value = value;
	}

	private void validate(int value) {
		if (value < 1) {
			throw new RuntimeException("Positive must be more then 0");
		}
	}

	public static Positive create(String value) {
		return new Positive(value);
	}

	public int getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Positive positive = (Positive)o;
		return value == positive.value;
	}

	@Override
	public int hashCode() {
		return value;
	}
}
