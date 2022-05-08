package dev.solar.calculator;

import java.util.Scanner;

public class InputView {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("계산기입니다.\n연산식을 적어주세요. (연산가능 식: +,-,*,/)");

        System.out.println(Calculator.calculate(scanner.nextLine()));
    }
}
