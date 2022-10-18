package lotto.domain;

import lotto.util.LottoNumber;

import java.util.ArrayList;
import java.util.List;

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

}
