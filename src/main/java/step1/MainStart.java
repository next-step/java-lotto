package step1;

import java.util.Scanner;

public class MainStart {
    public static void main(String[] args) {
        StringAddCalculator calculator = new StringAddCalculator();

        Scanner scanner= new Scanner(System.in);
        String userInput = scanner.nextLine();
        userInput += "\n"+scanner.nextLine();
//        String userInput2 = "//;\n1;2;3";

        int result = calculator.splitAndSum(userInput);
        System.out.println(result);
    }
}
