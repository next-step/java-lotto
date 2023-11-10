package calculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("계산식을 입력하시오(숫자와 사칙 연산 사이에는 반드시 빈 공백이 있어야 함)");
        String input = scanner.nextLine();

        calculation(new Seperator().split(input));
    }

    private static void calculation(String[] text) {
        Operator operator = new Operator();
        Seperator seperator = new Seperator();
        Integer result = Integer.parseInt(text[0]);

        for (int i = 1; i <= Math.floor((double) text.length / 2); i++) {
            seperator.isOperator(text[2 * i - 1]);
            result = operator.operation(text[2 * i - 1], String.valueOf(result), text[2 * i]);
        }

        System.out.println("= " + result);
    }
}
