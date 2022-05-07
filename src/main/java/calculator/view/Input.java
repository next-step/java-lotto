package calculator.view;

import java.util.Scanner;

public class Input {

    private static final String INPUT_MSG = "문자열을 입력해주세요";
    private static final Scanner scanner = new Scanner(System.in);

    public static String readExp(){
        System.out.println(INPUT_MSG);
        String exp = scanner.nextLine();
        if(exp == null){
            throw new IllegalArgumentException("null error");
        }
        return exp.replace(" ","");
    }
}
