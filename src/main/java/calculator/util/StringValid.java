package calculator.util;

public class StringValid {

	public static final String CALCULATOR_ADD_SEPARATOR_FLAG = "//";

	/**
	 * 클래스의 인스턴스화를 방지하기 위해 private 생성자 작성
	 */
	private StringValid() {
		throw new AssertionError();
	}

	/**
	 * 문자열 벨리데이션 메서드
	 * @param validStr: 유저 입력 문자열
	 * @return null 이거나, 빈값이면 true, 아니면 false
	 */
	public static boolean isEmptyStr(String validStr) {
		return validStr == null || validStr.trim().isEmpty();
	}

	/**
	 * 숫자 벨리데이션 메서드
	 * @param validStr: 유저 입력 문자열
	 * @return 숫자면 true, 아니면 false 리턴
	 */
	public static boolean isNumber(String validStr) {
		try {
			Integer.parseInt(validStr);
			return true;
		} catch (NumberFormatException numberFormatException) {
			return false;
		}
	}

	/**
	 * 숫자 벨리데이션 메서드
	 * @param validStr: 유저 입력 문자열
	 * @return 숫자가 아니면 true
	 */
	public static boolean isNoNNumber(String validStr) {
		return !isNumber(validStr);
	}

	/**
	 * 문자열 계산식 추가 구분자 체크 메서드
	 * @param validStr: 유저 입력 문자열
	 * @return 추가 구분자 '//' 가 있으면 true, 아니면 false
	 */
	public static boolean isAddSeparator(String validStr) {
		return validStr.contains(CALCULATOR_ADD_SEPARATOR_FLAG);
	}
}
