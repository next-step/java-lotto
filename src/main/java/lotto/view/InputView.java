package lotto.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    private final static String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String INPUT_WINNER_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    public String printInputMessageNGetAmount(){
        System.out.println(INPUT_AMOUNT_MESSAGE);
        return scanner.nextLine();
    }

    public String printInputMessageNGetWinnerNumbers(){
        System.out.println(INPUT_WINNER_NUMBERS_MESSAGE);
        return scanner.nextLine();
    }

}
