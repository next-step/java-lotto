package lotto;

import java.util.List;

public class Lotto {
    List<LottoGame> lottoGames;

    public Lotto(List<LottoGame> lottoGame) {
        this.lottoGames = lottoGame;
    }

    public LottoResult result(WinningNumber winningNumber) {
        LottoResult lottoResult = new LottoResult();
        for (LottoGame lottoGame : lottoGames) {
            int winningNumberCount = lottoGame.winningNumberCount(winningNumber);
            lottoResult.increase(winningNumberCount);
        }
        return lottoResult;
    }
}
