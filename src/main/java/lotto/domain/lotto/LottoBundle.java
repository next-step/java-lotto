package lotto.domain.lotto;

import java.util.List;

public class LottoBundle {

    private final List<Lotto> lottoList;

    public LottoBundle(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> unfoldLottoBundle() {
        return List.copyOf(this.lottoList);
    }
}
