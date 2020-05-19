package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoLine {

    private final LottoNums lottoNums;

    public LottoLine(LottoNums lottoNums) {
        this.lottoNums = lottoNums;
    }

    public LottoMatch getLottoMatch(LottoNums lottoNums) {
        return LottoMatch.valueByCount(this.lottoNums.getMatchCount(lottoNums));
    }

    public List<Integer> getNums() {
        return new ArrayList<>(this.lottoNums.toList());
    }
}
