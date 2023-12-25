package lotto.domain;

public class Digit {
	private final int digit;

	public Digit(int digit) {
		this.digit = digit;
	}

	public boolean compareTo(Digit y){
		return digit >= y.digit;
	}
}
