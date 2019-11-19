package step2.numbers;

import step2.analyze.Prize;
import step2.game.GameStrategy;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private final WinningNumbers numbers;
    private final Number bonusNumber;

    public WinningLotto(String inputNumbers, int bonusNumber) {
        WinningNumbers winningNumbers = new WinningNumbers(inputNumbers);
        winningNumbers.verifyLottoNumberOrBonusNumber(bonusNumber);
        this.numbers = winningNumbers;
        this.bonusNumber = Number.valueOf(bonusNumber);
    }

    public boolean contains(Number integer) {
        return numbers.contains(integer);
    }

    public boolean hasBonus(List<Number> userLotto) {
        return userLotto.contains(bonusNumber);
    }

    public List<Prize> getWinningCount(GameStrategy manualGames) {
        List<Prize> winningCount = new ArrayList<>();
        for (LottoGame lottoGame : manualGames.getGames()) {
            Prize prize
                    = Prize.of(lottoGame.matchWinningNumberCount(this),
                    lottoGame.containsBonus(this));
            winningCount.add(prize);
        }
        return winningCount;
    }
}
