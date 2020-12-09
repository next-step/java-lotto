package step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    
    private static final Pattern pattern = Pattern.compile(Constants.REGEX_CUSTOM_DELIMITER);

    /**
     * 문자열 덧셈 계산기의 핵심 메소드
     * @param input 입력 받은 문자열
     * @return 문자열 계산기의 결과값
     */
    public int splitAndSum(String input) {
        if (isNullOrBlank(input)) {
            return Constants.ZERO;
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
        if (isOnlyNumber(input)) {
            return Integer.parseInt(input);
        }
        return getSumOfNumbers(getSplitNumbers(input));
    }

    /**
     * 입력 받은 문자열이 숫자로만 이루어져 있는지 확인하는 메소드
     * @param input 입력 받은 문자열
     * @return 숫자로만 이루어져있는지 여부
     */
    private boolean isOnlyNumber(String input) {
        return input.matches(Constants.REGEX_IF_ONLY_NUMBERS);
    }

    /**
     * 입력받은 문자열을 구분자로 분리하는 메소드
     * @param input 입력 받은 문자열
     * @return 분리된 문자 배열
     */
    private String[] getSplitNumbers(String input) {
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String customDelimiter = matcher.group(Constants.POSITION_OF_CUSTOM_DELIMITER);
            return matcher.group(Constants.POSITION_OF_INPUT).split(customDelimiter);
        }
        return input.split(Constants.REGEX_BASIC_DELIMITER);
    }

    /***
     * 분리된 숫자들의 합계 반환하는 메소드
     * @param numbers 구분자로 분리된 숫자 배열
     * @return 숫자들의 합계
     */
    private int getSumOfNumbers(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(number -> {
                    if (Integer.parseInt(number) < Constants.ZERO) {
                        throw new RuntimeException();
                    }
                    try {
                        return Integer.parseInt(number);
                    } catch (RuntimeException e) {
                        throw new RuntimeException();
                    }
                }).sum();
    }
}
