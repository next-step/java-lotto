package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoLine {

    private final LottoNums lottoNums;

    public LottoLine(LottoNums lottoNums) {
        this.lottoNums = lottoNums;
    }

    public Rank getRank(LottoNums lottoNums) {
        return Rank.valueByCount(this.lottoNums.getCountOfMatch(lottoNums));
    }

    public List<Integer> getNums() {
        return new ArrayList<>(this.lottoNums.toList());
    }
}
