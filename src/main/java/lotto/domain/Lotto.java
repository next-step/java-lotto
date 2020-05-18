package lotto.domain;


import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final LottoNums lottoNums;

    public Lotto(LottoNums lottoNums) {
        this.lottoNums = lottoNums;
    }

    public LottoMatch getLottoMatch(LottoNums lottoNums) {
        return LottoMatch.valueByCount(this.lottoNums.getMatchCount(lottoNums));
    }

    public List<Integer> getNums() {
        return new ArrayList<>(this.lottoNums.toList());
    }
}
