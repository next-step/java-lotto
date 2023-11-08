package calculator;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static String inputText(){
        String text = SCANNER.nextLine();
        return validate(text);
    }

    private static String validate(String text) {
        if(text==null || text.isBlank()){
            throw new InputMismatchException("원하는 계산값을 입력하여주세요");
        }
        return text;
    }


}
