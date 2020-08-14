import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class StringCalculatorMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("문자열 덧셈 수식을 입력해주세요");
        String param = sc.nextLine();
        String delimiter = "[,:]";

        if (param == null || param.equals("")) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        param = param.replace("\"", "");

        if (param.startsWith("//")) {
            delimiter = param.substring(2, 3);
            param = param.substring(5);
        }
        String[] split = param.split(delimiter);

        //validation
        for (String value : split) {
            if (!Pattern.matches("[0-9]", value)) {
                throw new IllegalArgumentException("숫자가 아닌 값을 입력하셨습니다.");
            }

            if (Integer.parseInt(value) < 0) {
                throw new IllegalArgumentException("0보다 큰 값을 입력해주세요.");
            }
        }

        int result = Arrays.stream(split).map(value -> Integer.parseInt(value))
                .reduce((number1, number2) -> number1 + number2)
                .get();

        System.out.println(result);
    }
}
