package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int GAME_PRICE = 1000;
    private final int gameCount;

    public LottoGame(int money) {
        this.gameCount = Math.floorDiv(Money.validate(money), GAME_PRICE);
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
}
