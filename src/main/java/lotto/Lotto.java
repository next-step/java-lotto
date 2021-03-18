package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    List<LottoGame> lottoGames;

    public Lotto(List<LottoGame> lottoGame) {
        this.lottoGames = lottoGame;
    }

    public List<LottoGameResult> result(WinningNumber winningNumber) {
        List<LottoGameResult> lottoGameResults = new ArrayList<>();
        for (LottoGame lottoGame : lottoGames) {
            LottoGameResult lottoGameResult = lottoGame.result(winningNumber);
            lottoGameResults.add(lottoGameResult);
        }
        return lottoGameResults;
    }
}
