package stringCalculator.view;

import stringCalculator.domain.Calculation;
import java.util.Scanner;

public class InputView {

    private static String[] inputArray;
    private static final Scanner scanner = new Scanner(System.in);

    public static void split(String inputString) {
        inputArray = inputString.split(" ");
        calculate();
    }

    public static void calculate() {
        for (int i = 0; i < inputArray.length; i++) {
            if(i == 0) {
                new Calculation(Integer.parseInt(inputArray[0]));
            }
            if(inputArray[i].equals("+")){
                Calculation.plus(Integer.parseInt(inputArray[i+1]));
            }
            if(inputArray[i].equals("-")){
                Calculation.minus(Integer.parseInt(inputArray[i+1]));
            }
            if(inputArray[i].equals("/")){
                Calculation.division(Integer.parseInt(inputArray[i+1]));
            }
            if(inputArray[i].equals("*")){
                Calculation.multiplication(Integer.parseInt(inputArray[i+1]));
            }
        }
    }

    public static String inputOperationsAndNumber() {
        System.out.println("연산을 입력하시오");
        return scanner.nextLine();
    }
}
