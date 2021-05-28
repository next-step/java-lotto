package lotto.view;

import lotto.domain.WinningLottoNumber;
import lotto.dto.PurchaseMoney;

import java.util.Scanner;

public class LottoInputView {
    private static final String MESSAGE_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_LAST_PRIZE_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private Scanner scanner;

    public LottoInputView() {
        scanner = new Scanner(System.in);
    }

    public PurchaseMoney questionPurchaseMoney() {
        System.out.println(MESSAGE_PURCHASE_MONEY);
        String playerInput = requestPlayerInput();

        return new PurchaseMoney(playerInput);
    }

    public WinningLottoNumber questionLastPrizeNumber() {
        System.out.println();
        System.out.println(MESSAGE_LAST_PRIZE_NUMBER);
        String playerInput = requestPlayerInput();

        return new WinningLottoNumber(playerInput);
    }

    public WinningLottoNumber questionBonusNumber(WinningLottoNumber winningLottoNumber) {
        System.out.println(MESSAGE_BONUS_NUMBER);
        String playerInput = requestPlayerInput();

        winningLottoNumber.applyBonusNumber(playerInput);
        return winningLottoNumber;
    }

    private String requestPlayerInput() {
        String playerInput = scanner.nextLine();
        return removeSpace(playerInput);
    }

    private String removeSpace(String playerInput) {
        return playerInput.replaceAll(" ", "");
    }
}
