import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    public static int splitAndSum(String input) {
        // 널, 빈 문자열 체크
        if (input == null || input.isEmpty()) {
            return 0;
        }
        // 스플릿
        String[] numbers = split(input);
        // 더하기
        return sum(numbers);
    }

    private static String[] split(String input) {
        String regex = ",|:";
        // 커스텀 구분자 확인
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if (m.find()) {
            regex = m.group(1);
            // 기존 input에서 커스텀 구분자 문자열 제거
            input = input.replaceAll("//(.)\n", "");
        }

        return input.split(regex);
    }

    private static int sum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int parseIntNumber = Integer.parseInt(number);
            checkNegative(parseIntNumber);
            sum += parseIntNumber;
        }
        return sum;
    }

    private static void checkNegative(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }
}
