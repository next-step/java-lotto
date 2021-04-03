package lotto.domain.lotto;

import java.util.List;

public class LottoOrderedList {
    private final List<Lotto> lottoList;

    public LottoOrderedList(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int getLottoOrderedCount() {
        return lottoList.size();
    }

}
