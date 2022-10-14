import calculator.Calculator;

import java.util.Scanner;

public class CalculatorApplication {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("원하는 연산을 입력하세요.");
        String str = sc.nextLine();
        if (str == null | str.equals(" ")) {
            throw new IllegalArgumentException("공백은 올 수 없습니다.");
        }
        int result = Calculator.calculate(str);
        System.out.println("결과값: " + result);
    }
}
