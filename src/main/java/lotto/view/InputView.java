package lotto.view;

import java.util.Scanner;

public class InputView {
    private final static Scanner SCANNER = new Scanner(System.in);

    private final static String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String INPUT_WINNER_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private InputView(){}

    public static String printInputMessageNGetAmount(){
        System.out.println(INPUT_AMOUNT_MESSAGE);
        return SCANNER.nextLine();
    }

    public static String printInputMessageNGetWinnerNumbers(){
        System.out.println(INPUT_WINNER_NUMBERS_MESSAGE);
        return SCANNER.nextLine();
    }

}
