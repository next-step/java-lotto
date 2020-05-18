package lotto;

import java.util.List;

public class LottoNums {

    private static final int LOTTO_COUNT = 6;
    private List<LottoNum> lottoNums;

    public LottoNums(List<LottoNum> lottoNums) {
        validate(lottoNums);
        this.lottoNums = lottoNums;
    }

    private void validate(List<LottoNum> lottoNums) {
        if(lottoNums.size() != LOTTO_COUNT){
            throw new IllegalArgumentException("lotto has only six nums");
        }
    }

    public int getMatchCount(LottoNums targetNums) {
        return (int) this.lottoNums.stream()
            .filter(num -> targetNums.contain(num))
            .count();
    }

    private boolean contain(LottoNum object) {
        return this.lottoNums.contains(object);
    }
}
