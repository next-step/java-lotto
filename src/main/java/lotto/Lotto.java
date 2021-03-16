package lotto;

import java.util.List;

public class Lotto {
    List<LottoGame> lottoGames;

    public Lotto(List<LottoGame> lottoGame) {
        this.lottoGames = lottoGame;
    }

    public LottoResult match(List<Integer> winningNumbers) {
        LottoResult lottoResult = new LottoResult();
        for (LottoGame lottoGame : lottoGames) {
            int matchCount = lottoGame.matches(winningNumbers);
            lottoResult.increaseMatchCount(matchCount);
        }
        return lottoResult;
    }
}
