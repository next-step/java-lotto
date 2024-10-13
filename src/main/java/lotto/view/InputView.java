package lotto.view;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.ticket.LottoTicket;
import lotto.domain.purchase.Purchase;

import java.util.Scanner;

public class InputView {
    private final static String INPUT_MONEY_QUESTION = "구입금액을 입력해 주세요.";
    private final Scanner SCANNER;

    public InputView(Scanner scanner) {
        this.SCANNER = scanner;
    }

    public int questionInputMoney() {
        System.out.println(INPUT_MONEY_QUESTION);

        return SCANNER.nextInt();
    }



}
