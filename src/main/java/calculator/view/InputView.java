package calculator.view;

import java.util.Scanner;

public class InputView {

    private static final String NUMBER_INPUT_MESSAGE = "계산할 숫자와 기호를 입력해주세요";
    private static final Scanner sc = new Scanner(System.in);

    private InputView(){

    }

    public static String inputNumber(){
        System.out.println(NUMBER_INPUT_MESSAGE);
        return sc.nextLine();
    }

}
