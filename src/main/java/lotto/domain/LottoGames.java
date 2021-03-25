package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGames {
    private final int payMoney;
    private final List<LottoGame> lottoGames;

    public LottoGames(int payMoney) {
        this.payMoney = payMoney;
        this.lottoGames = makeLottoGames();
    }

    private List<LottoGame> makeLottoGames() {
        List<LottoGame> lottoGameList = new ArrayList<>();

        for (int i = 0; i < payMoney / 1000; i++) {
            lottoGameList.add(new LottoGame());
        }
        return lottoGameList;
    }

    public void makeNumbers() {
        for (LottoGame lottoGame : lottoGames) {
            lottoGame.makeNumbers();
        }
    }

    public int getGameCount() {
        return lottoGames.size();
    }

    public List<LottoGame> getLottoGames() {
        return lottoGames;
    }

    public HitResults result(WinNumbers winNumbers) {
        HitResults hitResults = new HitResults(payMoney);
        for (LottoGame lottoGame : lottoGames) {
            hitResults.add(lottoGame.lotto(winNumbers));
        }

        return hitResults;
    }

}
