package util;

public class InputValidation {
	public static Boolean checkNullAndEmpty (String input) {
		if (input == null || input.equals("")) {
			return Boolean.TRUE;
		}

		return Boolean.FALSE;
	}

	public static Boolean checkSingle (String input) {
		try {
			Integer.parseInt(input);

			return Boolean.TRUE;

		} catch (NumberFormatException e) {
			return Boolean.FALSE;
		}
	}


}
