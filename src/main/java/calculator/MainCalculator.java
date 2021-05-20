package calculator;

import java.util.Scanner;

public class MainCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringCalculator stringCalculator = new StringCalculator();

        System.out.println(stringCalculator.calculate(scanner.next()));
    }
}
