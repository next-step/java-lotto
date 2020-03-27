package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.domain.Constant.DEFAULT_GAME_PRICE;

public class LottoGame {
    private final int gameCount;

    public LottoGame(int money) {
        this.gameCount = Math.floorDiv(Money.validate(money), DEFAULT_GAME_PRICE);
    }

    public int getGameCount() {
        return gameCount;
    }

    public LottoNumbers buy() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < gameCount; i++) {
            lottoNumbers.add(new LottoNumber(LottoNumberAutoGenerator.get()));
        }
        return new LottoNumbers(lottoNumbers);
    }

    public LottoGameResults checkResult(LottoNumbers boughtNumbers, List<Integer> winningNumber) {
        return new LottoGameResults(boughtNumbers, new LottoNumber(winningNumber));
    }
}
