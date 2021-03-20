package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int LOTTO_PRICE = 1000;
    private List<LottoGame> lottoGames;

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

    public List<LottoMatchNumbers> result(WinningNumber winningNumber) {
        List<LottoMatchNumbers> lottoNumberMatches = new ArrayList<>();
        for (LottoGame lottoGame : lottoGames) {
            LottoMatchNumbers matchNumbers = lottoGame.matchNumbers(winningNumber);
            lottoNumberMatches.add(matchNumbers);
        }
        return lottoNumberMatches;
    }
}
