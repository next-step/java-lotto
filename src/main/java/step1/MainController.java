package step1;

import java.util.Scanner;

public class MainController {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();
        StringAddCalculator stringAddCalculator = new StringAddCalculator(input);

        int result = stringAddCalculator.calculate();

        System.out.println(result);
    }
}
