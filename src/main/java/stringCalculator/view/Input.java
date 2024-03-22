package stringCalculator.view;

import java.util.Scanner;

public class Input {

    private static Scanner scanner = new Scanner(System.in);

    public static String inputNumericFormula(){
        System.out.println("수식을 입력해주세요");
        return scanner.nextLine();
    }
}
