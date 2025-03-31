package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class LottoWallet implements Iterable<Lotto> {

    private final List<Lotto> lottos;
    private final int manuelSize;

    public LottoWallet(List<Lotto> lottos, int manuelSize) {
        this.lottos = lottos;
        this.manuelSize = manuelSize;
    }
    public LottoWallet(List<Lotto> lottos) {
        this(lottos, 0);
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public int autoLottoCount() {
        return lottos.size() - this.manuelLottoCount();
    }
    public int manuelLottoCount() { return this.manuelSize; }

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
