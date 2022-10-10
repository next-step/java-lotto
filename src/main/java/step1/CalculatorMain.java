package step1;

import java.util.Scanner;
import step1.domains.CalculateOperator;

public class CalculatorMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CalculateOperator calculateOperator = new CalculateOperator(scanner.nextLine());

        System.out.println(calculateOperator.calculate());
    }
}
