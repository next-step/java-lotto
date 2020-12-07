package step1;

public class StringCalculator {

    /**
     * 문자열 덧셈 계산기의 핵심 메소드
     * @param input 입력 받은 문자열
     * @return 문자열 계산기의 결과값
     */
    public int splitAndSum(String input) {
        if (isNullOrBlank(input)) {
            return 0;
        }
        return getSum(input);
    }

    /**
     * 문자열이 빈 문자열 또는 null 인지 확인하는 메소드
     * @param input 입력 받은 문자열
     * @return 해당 문자열의 빈 문자열 또는 null 여부 반환
     */
    private boolean isNullOrBlank(String input) {
        return input == null || input.trim().isEmpty();
    }

    /**
     * 빈 문자열 또는 null이 아닌 문자열에 대해 덧셈 결과 반환하는 메소드
     * @param input 입력 받은 문자열
     * @return 덧셈 결과
     */
    private int getSum(String input) {
        if (input.matches("^[0-9]+$")) {
            return Integer.parseInt(input);
        }
        return 0;
    }
}
