package calculator.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scan = new Scanner(System.in);

    public static String mathematicalExpressionString(){
        System.out.println("Enter the String with valid Mathematical Expression");
        return scan.nextLine();
    }
}
