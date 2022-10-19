package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static lotto.util.LottoNumber.getAutoNumberList;

public class Lottos {

    private final Integer amount;
    private final Integer purchasePrice;
    private List<Lotto> lottoList;

    public Lottos(Integer amount, Integer purchasePrice) {
        this.amount = amount;
        this.purchasePrice = purchasePrice;
    }

    public Lottos(Integer amount, Integer purchasePrice, List<Lotto> lottoList) {
        this.amount = amount;
        this.purchasePrice = purchasePrice;
        this.lottoList = lottoList;
    }

    public Lottos pick() {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            lottoList.add(new Lotto().auto(getAutoNumberList()));
        }

        this.lottoList = lottoList;
        return this;
    }

    public Lottos rank(List<Integer> matchNumberList) {
        lottoList.forEach(l -> l.rank(matchNumberList));
        return this;
    }

    public Integer getPurchasePrice() {
        return purchasePrice;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos = (Lottos) o;
        return Objects.equals(amount, lottos.amount) && Objects.equals(lottoList, lottos.lottoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, lottoList);
    }
}
