package lotto.view;

import lotto.domain.LottoGame;
import lotto.domain.WinningLottoNumber;
import lotto.dto.ManuallyPurchasingLottoCount;
import lotto.dto.ManuallyPurchasingLottoNumber;
import lotto.dto.PurchaseMoney;

import java.util.Scanner;

import static lotto.domain.LottoNumber.valueOf;

public class LottoInputView {
    private static final String MESSAGE_PURCHASE_MONEY = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_MANUAL_PURCHASE_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MESSAGE_MANUAL_PURCHASE_LOTTO_DETAIL = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String MESSAGE_LAST_PRIZE_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    private Scanner scanner;

    public LottoInputView() {
        scanner = new Scanner(System.in);
    }

    public PurchaseMoney questionPurchaseMoney() {
        System.out.println(MESSAGE_PURCHASE_MONEY);

        return new PurchaseMoney(requestPlayerInput());
    }

    public ManuallyPurchasingLottoCount questionManualPurchasingCount() {
        System.out.println(MESSAGE_MANUAL_PURCHASE_LOTTO_COUNT);
        return new ManuallyPurchasingLottoCount(requestPlayerInput());
    }

    public void questionManualPurchasingLottoNumber() {
        System.out.println(MESSAGE_MANUAL_PURCHASE_LOTTO_DETAIL);
    }

    public ManuallyPurchasingLottoNumber answerManualPurchasingLottoNumber() {
        return new ManuallyPurchasingLottoNumber(requestPlayerInput());
    }

    public WinningLottoNumber questionLastPrizeNumber() {
        System.out.println();
        System.out.println(MESSAGE_LAST_PRIZE_NUMBER);
        LottoGame lottoGame = LottoGame.createManual(requestPlayerInput());
        return new WinningLottoNumber(lottoGame);
    }

    public WinningLottoNumber questionBonusNumber(WinningLottoNumber winningLottoNumber) {
        System.out.println(MESSAGE_BONUS_NUMBER);

        winningLottoNumber.applyBonusNumber(valueOf(requestPlayerInput()));
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
