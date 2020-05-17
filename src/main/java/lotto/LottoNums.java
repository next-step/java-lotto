package lotto;

import java.util.List;

public class LottoNums {
    private List<LottoNum> lottoNums;

    public LottoNums(List<LottoNum> lottoNums) {
        if(lottoNums.size() != 6){
            throw new IllegalArgumentException("lotto has only six nums");
        }
        this.lottoNums = lottoNums;
    }
}
