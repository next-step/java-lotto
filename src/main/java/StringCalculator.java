import org.assertj.core.util.Strings;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private final static int SUM_FAILED = 0;
    private final static String SEPARATOR = ",|:";
    private final static String PATTERN = "//(.)\n(.*)";

    public static int add(String input) throws Exception {
        if (Strings.isNullOrEmpty(input))
            return SUM_FAILED;

        Matcher m = Pattern.compile(PATTERN).matcher(input);
        if (m.find())
            return splitCustomSum(m);

        return splitAndSum(input);
    }

    // 구분자가 ",", ":" 일때 계산하는 함수
    private static int splitAndSum(String input) {
        String[] result = input.split(SEPARATOR);
        if (checkNagative(result))
            throw new RuntimeException("입력값이 잘못되었습니다. 입력값 중에 음수가 있습니다.");
        return getTotalSum(result);
    }

    // split한 입력값에 "-" 체크하는 함수하여 음수값 여부 판단하는 함수
    private static boolean checkNagative(String[] inputs) {
        String splitInputs = Arrays.toString(inputs);
        return splitInputs.contains("-");
    }

    // cumtom 구분자일때 계산하는 함수
    private static int splitCustomSum(Matcher matcher) {
        String customDelimiter = matcher.group(1);
        String[] tokens = matcher.group(2).split(customDelimiter);
        return getTotalSum(tokens);
    }

    // 구분자로 split 문자열을 덧셈해주는 함수
    private static int getTotalSum(String[] inputs) {
        int sum = 0;
        for (int i = 0; i < inputs.length; ++i) {
            sum += Integer.parseInt(inputs[i]);
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("덧셈을 위한 문자열을 입력해주세요.");
        int result = StringCalculator.add(sc.nextLine());
        System.out.println("실행결과: " + result);
    }
}
