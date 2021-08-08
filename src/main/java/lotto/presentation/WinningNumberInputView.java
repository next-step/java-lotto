package lotto.presentation;

import java.util.Scanner;

public class WinningNumberInputView {

    public static final String WINNING_NUMBER_INPUT_COMMENT = "지난 주 당첨 번호를 입력해 주세요.";

    public String input(){
        System.out.println(WINNING_NUMBER_INPUT_COMMENT);
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
