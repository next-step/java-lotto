package lotto;

import java.util.List;

public class Lotto {
    List<LottoGame> lottoGames;

    public Lotto(List<LottoGame> lottoGame) {
        this.lottoGames = lottoGame;
    }

    public LottoResult result(List<Integer> winningNumbers) {
        LottoResult lottoResult = new LottoResult();
        for (LottoGame lottoGame : lottoGames) {
            int winningNumberCount = lottoGame.winningNumberCount(winningNumbers);
            lottoResult.increase(winningNumberCount);
        }
        return lottoResult;
    }
}
