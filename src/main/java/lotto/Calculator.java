package lotto;

import java.util.Scanner;

import lotto.domain.StringArithmeticInput;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("계산식을 입력해주세요: ");
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        System.out.println(new StringArithmeticInput(expression).evaluate().getValue());
    }
}
