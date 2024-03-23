package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto> {

    private final List<Lotto> lottos;

    public Lottos(int price) {
        this(price, Collections.emptyList());
    }

    public Lottos(int price, List<LottoFactory> lottoFactory) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(getLottoWithFactory(lottoFactory));
        lottos.addAll(getLottoWithRandomFactory(price / Lotto.PRICE - lottos.size()));
        this.lottos = List.copyOf(lottos);
    }

    private List<Lotto> getLottoWithRandomFactory(int size) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottos.add(new RandomLottoFactory().create());
        }
        return lottos;
    }

    private List<Lotto> getLottoWithFactory(List<LottoFactory> lottoFactory) {
        List<Lotto> lottos = new ArrayList<>();
        for (LottoFactory factory : lottoFactory) {
            lottos.add(factory.create());
        }
        return lottos;
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int totalPrice() {
        return this.lottoCount() * Lotto.PRICE;
    }

    public int lottoCount() {
        return lottos.size();
    }

    @Override
    public String toString() {
        return lottos.toString();
    }

    @Override
    public Iterator<Lotto> iterator() {
        return lottos.iterator();
    }
}
