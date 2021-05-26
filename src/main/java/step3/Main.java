package step3;

import step3.domain.BonusNumber;
import step3.domain.Lotto;
import step3.domain.LottoGame;
import step3.domain.Money;
import step3.ui.InputView;

public class Main {
    public static void main(String[] args) {
        int amount = InputView.purchaseAmount();
        LottoGame lottoGame = new LottoGame(new Money(amount));

        Lotto winningNumbers = getWinningNumbers(lottoGame);
        BonusNumber bonusNumber = getBonusNumber(lottoGame, winningNumbers);


        lottoGame.getStatistics(winningNumbers,bonusNumber);
    }

    private static BonusNumber getBonusNumber(LottoGame lottoGame, Lotto winningNumbers) {
        int bonusNum = InputView.getBonusNumber();
        return lottoGame.getBonusNum(winningNumbers,bonusNum);
    }

    private static Lotto getWinningNumbers(LottoGame lottoGame) {
        String winNum = InputView.getWinningNumbers();
        return lottoGame.getWinLottoNum(winNum);
    }
}
