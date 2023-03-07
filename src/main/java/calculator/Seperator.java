package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Seperator {

    private static final String DEFAULT_SEPERATOR = ",|:"; // 기본 구분자 체크 정규식
    private final String[] speratedValue; // 연산자 문자열 배열

    /**
     * 구분자 객체 생성자
     *
     * @param inputString : 입력값
     */
    public Seperator(String inputString) {
        this.speratedValue = this.parseWithSeperator(inputString);
    }

    /**
     * 구분자 getter
     *
     * @return : 연산자 문자열 배열
     */
    public String[] getSperatedValue() {
        return this.speratedValue;
    }

    /**
     * 입력값 내 구분자 판단 및 분리 함수
     *
     * @param inputString : 입력값
     * @return : 연산자 문자열 배열
     */
    private String[] parseWithSeperator(String inputString) {
        String[] parseResult;
        Matcher m = Pattern.compile("//(.)\\n*.*").matcher(inputString);
        if (m.find()) {
            String customDelimiter = m.group(1);
            customDelimiter = this.validateContextSplitString(customDelimiter);
            parseResult = this.getDelimiterSplitValue(inputString)
                .split(customDelimiter);
            return parseResult;
        }
        parseResult = inputString.split(DEFAULT_SEPERATOR);
        return parseResult;
    }

    /**
     * 입력값 내 구분자 영역 제외한 부분 추출 함수
     *
     * @param inputString : 입력값
     * @return : 구분자 영역 제외 부분 값
     */
    private String getDelimiterSplitValue(String inputString) {
        return inputString.substring(inputString.indexOf("\\n") + 2);
    }

    /**
     * 구분자 값이 개행 문자 혹은 기타 추가적인 예외처리 필요한 지 체크하여 리턴
     *
     * @param delimiter : 구분자 값
     * @return : 예외 처리 된 구분자 값
     */
    private String validateContextSplitString(String delimiter) {
        if (delimiter.equals("[") || delimiter.equals("\n") || delimiter.equals("{")
            || delimiter.equals("*")
            || delimiter.equals("\r")) {
            return "\\" + delimiter;
        }
        return delimiter;
    }
}
