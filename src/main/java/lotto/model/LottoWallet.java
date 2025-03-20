package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoWallet {

    private final List<Lotto> lottos;

    public LottoWallet(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public Lotto getLotto(int index) {
        return lottos.get(index);
    }

    public LottoResult calculateResult(LottoWinningNumber winningNumber) {
        List<LottoPrize> lottoPrizes = new ArrayList<>();
        for (Lotto lotto : lottos) {
            LottoPrize rank = winningNumber.getRank(lotto);
            lottoPrizes.add(rank);
        }
        return new LottoResult(lottoPrizes);
    }

}
