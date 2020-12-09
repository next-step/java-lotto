package com.nextstep.lotto.calculator;

import java.util.Scanner;

public class CalculatorManager {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new CalculatorManager().run();
    }

    public void run() {
        String source = input();
        int result = StringAddCalculator.splitAndSum(source);
        output(result);
    }

    private String input() {
        System.out.print("Input : ");
        String temp = scanner.nextLine();
        return temp.replace("\\n", "\n");
    }

    private void output(int result) {
        System.out.println("Output : " + result);
    }
}
