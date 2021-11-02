package stringcalculator.views;

import java.util.Scanner;

public class InputView {

    public static String getWord() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("문자열 계산기입니다. 계산하실 숫자를 구분자로 구분하여 입력해주세요.");
        if (!scanner.hasNext()) {
            throw new NullPointerException("입력값이 없습니다.");
        }
        return scanner.nextLine();
    }
}
