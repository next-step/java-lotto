package lotto.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Lotto {
    private final LottoNums lottoNums;

    public Lotto(LottoNums lottoNums) {
        this.lottoNums = lottoNums;
    }

    public Optional<LottoMatch> getLottoMatch(LottoNums lottoNums) {
        return LottoMatch.valueByCount(this.lottoNums.getMatchCount(lottoNums));
    }

    public List<Integer> getNums() {
        return new ArrayList<>(this.lottoNums.toList());
    }
}
