package lotto.domain;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.google.common.base.Preconditions.checkState;

public class Lottos implements Iterable<Lotto> {

    private static final String SIZE_EXCEEDED_MESSAGE = "lotto size exceeded";

    private final int initSize;
    private final List<Lotto> lottos;

    public Lottos(int initSize) {
        this.initSize = initSize;
        lottos = new ArrayList<>();
    }

    public int fillAuto() {
        int remainSize = initSize - lottos.size();
        for (int i = 0; i < remainSize; i++) {
            lottos.add(Lotto.generateAuto());
        }
        return remainSize;
    }

    @Nonnull
    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }

    public void add(Lotto lotto) {
        checkState(lottos.size() < initSize, SIZE_EXCEEDED_MESSAGE);
        lottos.add(lotto);
    }

    public LottoResult matchWinningLotto(WinningLotto winningLotto) {
        LottoResult result = new LottoResult(getTotalPrice());
        for (Lotto lotto : lottos) {
            result.addRanking(winningLotto.match(lotto));
        }
        return result;
    }

    public int getTotalPrice() {
        return lottos.size() * LottoShop.DEFAULT_PRICE_UNIT;
    }

}
