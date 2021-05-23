package domain;

import util.ExceptionMessage;

public class Number {
	private Long number;

	public Number () {
		this("");
	}

	public Number (String number) {
		try {
			checkMinus(number);
			this.number = Long.valueOf(number);

		} catch (NumberFormatException e) {
			throw new NumberFormatException(ExceptionMessage.NUMBER_FORMAT_EXCEPTION);
		}
	}

	@Override
	public boolean equals (Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Number number1 = (Number) o;

		return number != null ? number.equals(number1.number) : number1.number == null;
	}

	@Override
	public int hashCode () {
		return number != null ? number.hashCode() : 0;
	}

	public Integer number () {
		return number.intValue();
	}

	private boolean checkMinus(String number){
		if (Integer.parseInt(number) < 0) {
			throw new NumberFormatException();
		}
		return true;
	}
}
