package stringCalculator.view;

import java.util.Scanner;

public class InputView {

    public String stringInputView(){
        System.out.println("사칙연산 값을 입력해주세요");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
