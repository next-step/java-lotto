package calculator;

import calculator.domain.StringAddCalculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int sum = StringAddCalculator.splitAndSum(new Scanner(System.in).nextLine());
        System.out.println(sum);
    }
}
