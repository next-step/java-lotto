package domain;

public class Number {
	private static String NUMBER_FORMAT_EXCEPTION = "숫자를 입력해주세요.";

	private Double number;

	public Number () {
		this("");
	}

	public Number (String number) {
		if (number.equals("")) {
			this.number = 0D;
			return;
		}

		try {
			this.number = Double.valueOf(number);
		} catch (NumberFormatException e) {
			throw new NumberFormatException(NUMBER_FORMAT_EXCEPTION);
		}
	}

	public Integer number () {
		return number.intValue();
	}
}
