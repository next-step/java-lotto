package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LottoWallet implements Iterable<Lotto> {

    private final List<Lotto> lottos;

    public LottoWallet(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int getLottoCount() {
        return lottos.size();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return Collections.unmodifiableList(lottos).iterator();
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
