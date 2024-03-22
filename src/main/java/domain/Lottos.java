package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lottos implements Iterable<Lotto> {

    private final List<Lotto> lottos;

    public Lottos(int price) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < price / Lotto.PRICE; i++) {
            lottos.add(new Lotto());
        }
        this.lottos = lottos;
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

    public double rateOfReturn(Lotto winningLotto) {
//        int totalPrize = 0;
//        for (Lotto lotto : lottos) {
//            totalPrize += lotto.rank(winningLotto).prizeMoney(1);
//        }
//        double result = (double) totalPrize / (this.getLottoCount() * 1000);
//        return BigDecimal.valueOf(result).setScale(2, RoundingMode.DOWN).doubleValue();
        return 0.0;
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
