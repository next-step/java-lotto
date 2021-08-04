package lotto.step1;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        Calculator calculator = new Calculator(text);
        int result = calculator.calculate();
        System.out.println(result);
    }
}
