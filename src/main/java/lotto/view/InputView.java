package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_MESSAGE_MONEY_FOR_LOTTO = "구입 금액을 입력해 주세요.";
    private static final String INPUT_MESSAGE_LAST_WEEK_LOTTO_WIN_NUMBERS = "\n지난 주 당첨 번호를 입력해 주세요.";

    public int showMessageAndGetMoneyInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(INPUT_MESSAGE_MONEY_FOR_LOTTO);

        return scanner.nextInt();
    }

    public String showMessageAndGetLastWeekLottoWinNumbers() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(INPUT_MESSAGE_LAST_WEEK_LOTTO_WIN_NUMBERS);

        return scanner.nextLine();
    }
}
