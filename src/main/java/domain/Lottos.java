package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto> {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos create(int price) {
        return create(price, Collections.emptyList());
    }

    public static Lottos create(int price, List<LottoFactory> lottoFactory) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(getLottoWithFactory(lottoFactory));
        lottos.addAll(getLottoWithRandomFactory(price / Lotto.PRICE - lottos.size()));
        return new Lottos(lottos);
    }

    private static List<Lotto> getLottoWithFactory(List<LottoFactory> lottoFactory) {
        List<Lotto> lottos = new ArrayList<>();
        for (LottoFactory factory : lottoFactory) {
            lottos.add(factory.create());
        }
        return lottos;
    }

    private static List<Lotto> getLottoWithRandomFactory(int size) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            lottos.add(new RandomLottoFactory().create());
        }
        return lottos;
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
