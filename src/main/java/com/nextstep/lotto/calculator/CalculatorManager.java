package com.nextstep.lotto.calculator;

import java.util.Scanner;

public class CalculatorManager {
    public static void main(String[] args) {
        new CalculatorManager().run();
    }

    public void run() {
        String source = input();
        int result = StringAddCalculator.splitAndSum(source);
        output(result);
    }

    public String input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input : ");
        String temp = scanner.nextLine();
        return temp.replace("\\n", "\n");
    }

    public void output(int result) {
        System.out.println("Output : " + result);
    }
}
