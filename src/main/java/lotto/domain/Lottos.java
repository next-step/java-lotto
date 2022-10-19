package lotto.domain;

import lotto.util.LottoNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lottos {

    private final Integer amount;
    private List<Lotto> lottoList;

    public Lottos(Integer amount) {
        this.amount = amount;
    }

    public Lottos autoPick() {
        List<Lotto> lottoList = new ArrayList<>();

        for (int i = 0; i < amount; i++) {
            lottoList.add(new Lotto(LottoNumber.getAutoNumberList()));
        }

        this.lottoList = lottoList;
        return this;
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
