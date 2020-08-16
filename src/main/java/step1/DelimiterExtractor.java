package step1;

public class DelimiterExtractor {
	private static final String DEFAULT_DELIMITER = ",|:";
	private static final String BACK_SLASHES = "\\\\";
	private static final String START_SIGN = "\\/\\/";
	private static final String END_SIGN = System.lineSeparator();

	private static StringBuilder delimiter = new StringBuilder(DEFAULT_DELIMITER);

	public String getDelimiter() {
		return delimiter.toString();
	}

	// getter를 따로 사용하지 않고 이 메서드에서 구분자를 바로 반환하고 싶었는데 잘 안돼서 분리한 문자열을 반환했습니다ㅠㅠ
	public String separateDelimiterAndIntegers(String inputString) {
		String[] separatedString = inputString.replaceAll(START_SIGN, BACK_SLASHES).split(END_SIGN);
		if (separatedString.length > 1) {
			changeDelimiter(separatedString[0]);
			return separatedString[1];
		}
		return separatedString[0];
	}

	private void changeDelimiter(String newDelimiter) {
		delimiter.replace(0, delimiter.length(), newDelimiter);
	}
}
