package Lotto.domain;

import java.util.List;

public class MyLotto {
    private final List<Lotto> lottoList;

    public MyLotto(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }
}
