package lotto.view;

import lotto.domain.WinningLottoNumber;
import lotto.dto.PurchaseMoney;

import java.util.Scanner;

public class LottoInputView {
    private static final String MESSAGE_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_LAST_PRIZE_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";

    private Scanner scanner;

    public LottoInputView() {
        scanner = new Scanner(System.in);
    }

    public PurchaseMoney questionPurchaseMoney() {
        System.out.println(MESSAGE_PURCHASE_MONEY);

        String playerInput = scanner.nextLine();
        playerInput = removeSpace(playerInput);

        return new PurchaseMoney(playerInput);
    }

    public WinningLottoNumber questionLastPrizeNumber() {
        System.out.println();
        System.out.println(MESSAGE_LAST_PRIZE_NUMBER);

        String playerInput = scanner.nextLine();
        playerInput = removeSpace(playerInput);

        return new WinningLottoNumber(playerInput);
    }

    private String removeSpace(String playerInput) {
        return playerInput.replaceAll(" ", "");
    }
}
