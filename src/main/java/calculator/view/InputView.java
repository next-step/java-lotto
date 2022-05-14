package calculator.view;

import java.util.Scanner;

public class InputView {

    public String inputNumberSentence() {
        System.out.println("계산할 식을 입력하세요(사칙연산만 가능):");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

}
