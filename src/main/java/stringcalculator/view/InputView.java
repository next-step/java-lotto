package stringcalculator.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView(){

    }

    public static String askExpression(){
        System.out.println("계산식을 입력해주세요.");
        return SCANNER.nextLine();
    }
}
