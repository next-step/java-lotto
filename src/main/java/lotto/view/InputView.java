package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String BUY_LOTTO_OF_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBER_OF_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private Scanner INPUT;

    public InputView(Scanner scanner) {
        this.INPUT = scanner;
    }

    public String setBuyLottoPrice() {
        System.out.println(BUY_LOTTO_OF_MESSAGE);

        return INPUT.nextLine();
    }

    public String setLottoNumber() {
        System.out.println(LOTTO_NUMBER_OF_MESSAGE);

        return INPUT.nextLine();
    }
}
