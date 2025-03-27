package calculator;

import java.util.Scanner;

public class StringCalculator {
    private static final String DELIMITER = " ";
    private String[] strs;

    StringCalculator(String str) {
        validate(str);
        this.strs = splitString(str);
    }

    public static String[] splitString(String str) {
        return str.split(DELIMITER);
    }

    private static void validate(String str) {
        if ( str == null || str.isEmpty() || str.isBlank()) {
            throw new IllegalArgumentException("빈값이 입력될 수 없습니다.");
        }
    }

    public int calculate() {
        int result = Integer.parseInt(strs[0]);
        for(int i = 1; i < strs.length; i+=2) {
            int nextNumber = Integer.parseInt(strs[i + 1]);

            String symbol = strs[i];
            Operator op = ArithmeticOperator.from(symbol);
            result = op.apply(result, nextNumber);
        }

        return result;
    }

    public static void main(String[] args) {
        String str = inputString();

        StringCalculator calculator = new StringCalculator(str);
        int result = calculator.calculate();

        System.out.println("결과=" + result);
    }

    private static String inputString() {
        Scanner in = new Scanner(System.in);
        System.out.print("계산식을 입력해주세요:");
        String str = in.nextLine();
        return str;
    }
}
