package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int LOTTO_PRICE = 1000;
    List<LottoGame> lottoGames;

    public Lotto(List<LottoGame> lottoGame) {
        this.lottoGames = lottoGame;
    }

    public Lotto(int purchaseAmounts, LottoNumber lottoNumber) {
        int buyLotto = purchaseAmounts / LOTTO_PRICE;
        lottoGames = new ArrayList<>();
        while (buyLotto-- > 0) {
            lottoGames.add(new LottoGame(lottoNumber));
        }
    }

    public List<LottoGame> lottoGames() {
        return lottoGames;
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
