package lotto_auto.model;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResultList {

    private final List<LottoResult> lottoResultList;

    public LottoResultList(List<LottoResult> lottoResultList) {
        this.lottoResultList = lottoResultList;
    }

    public int size() {
        return lottoResultList.size();
    }

    public int getRankLottoCount(int rank) {
        List<LottoResult> collect = this.lottoResultList.stream()
                .filter(item -> item.getRank() == rank)
                .collect(Collectors.toList());
        return collect.size();
    }
}
