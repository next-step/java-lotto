package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGames {

    private static final int lottoOneGamePrice = 1000;

    private static List <Lotto> lottos;

    public LottoGames() {
        lottos = new ArrayList <>();
    }

    public void setLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public double rateOfReturn() {
        return Math.round((sumWinnerPrice() / (float) totalLottoGamePrice() * 100) * 100) / 100.0;
    }

    private int sumWinnerPrice() {
        return lottos.stream().mapToInt(lotto -> lotto.getWinnerPrice()).sum();
    }

    private int totalLottoGamePrice() {
        return lottoOneGamePrice * lottos.size();
    }

}
