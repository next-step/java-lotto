package view;

import java.util.Scanner;

public class InputView {

    public static final Scanner SCANNER = new Scanner(System.in);

    public static String inputCarValue(){

        System.out.println("숫자와 연산자를 빈공백으로 분리 하여 입력 해주세요");
        return SCANNER.nextLine();
    }


}
