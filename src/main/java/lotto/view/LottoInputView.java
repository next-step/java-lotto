package lotto.view;

import lotto.domain.LottoGame;
import lotto.domain.LottoGames;
import lotto.domain.WinningLottoNumber;
import lotto.dto.ManuallyPurchasingLottoCount;
import lotto.dto.PurchaseMoney;

import java.util.ArrayList;
import java.util.List;
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

    public LottoGames questionManualPurchasingLotto() {
        System.out.println(MESSAGE_MANUAL_PURCHASE_LOTTO_COUNT);
        ManuallyPurchasingLottoCount manuallyPurchasingLottoCount = new ManuallyPurchasingLottoCount(requestPlayerInput());

        System.out.println(MESSAGE_MANUAL_PURCHASE_LOTTO_DETAIL);
        List<LottoGame> lottoGames = new ArrayList<>();
        for (int i = 0; i < manuallyPurchasingLottoCount.getValue(); i++) {
            String manualLottoNumbers = requestPlayerInput();
            LottoGame lottoGame = LottoGame.createManual(manualLottoNumbers);
            lottoGames.add(lottoGame);
        }
        return new LottoGames(lottoGames);
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
