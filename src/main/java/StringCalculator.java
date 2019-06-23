import org.assertj.core.util.Strings;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private final static int SUM_FAILED = 0;
    private final String PATTERN = "//(.)\n(.*)";

    public int add(String input) throws Exception {
        if (Strings.isNullOrEmpty(input)) // 빈 문자열과 null 값 처리
            return SUM_FAILED;

        if (input.length() == 1)          // 숫자 하나 처리
            return Integer.parseInt(input);

        if (input.contains("//"))         //  cumstom 구분자 처리
            return splitCustomSum(input);

        if (input.contains("-"))          // 음수 입력시 Exception 처리
            throw new RuntimeException("입력값이 잘못되었습니다. 입력값 중에 음수가 있습니다.");

        return splitAndSum(input);       // 구분자 ",", ":" 처리
    }
    // 구분자가 ",", ":" 일때 계산하는 함수
    private int splitAndSum(String input) {
        String[] result = input.split(",|:");
        return getSumofArray(result);
    }
    // cumtom 구분자일때 계산하는 함수
    private int splitCustomSum(String input) {
        Matcher m = Pattern.compile(PATTERN).matcher(input);
        System.out.println("Matcher: " +m);
        if (m.find()) {
            System.out.println("splitCustomSum");
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return getSumofArray(tokens);
        }
        return SUM_FAILED;
    }
    // 구분자로 split 문자열을 덧셈해주는 함수
    private int getSumofArray(String[] inputs) {
        System.out.println("getSumofArray");
        int sum = 0;
        for (int i = 0; i < inputs.length; ++i) {

            sum += Integer.parseInt(inputs[i]);
        }
        return sum;
    }


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("덧셈을 위한 문자열을 입력해주세요.");

        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.add(sc.nextLine());
        System.out.println("실행결과: " + result);

    }
}
