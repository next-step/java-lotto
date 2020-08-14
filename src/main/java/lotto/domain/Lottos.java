package lotto.domain;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Lottos implements Iterable<Lotto> {

    private final List<Lotto> lottos = new ArrayList<>();

    public void generateAuto(int count) {
        for (int i = 0; i < count; i++) {
            lottos.add(Lotto.generateAuto());
        }
    }

    @Nonnull
    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }

    public int size() {
        return lottos.size();
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public void findLottoResult(Lotto winningLotto, LottoNumber bonusBall, Consumer<LottoRanking> rankingConsumer) {
        for (Lotto lotto : lottos) {
            int countOfMatch = winningLotto.countOfMatch(lotto);
            rankingConsumer.accept(LottoRanking.valueOf(countOfMatch, () -> lotto.contain(bonusBall)));
        }
    }

    public int getTotalPrice() {
        return lottos.size() * LottoShop.DEFAULT_PRICE_UNIT;
    }

}
