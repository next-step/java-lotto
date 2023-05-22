package step2.domain.Lotto;

import step2.domain.Rank;

import java.util.List;

public class Lotto {

    private final LottoNums lottoNums;

    public Lotto(LottoNums lottoNums) {
        this.lottoNums = lottoNums;
    }

    public String getNums() {
        return lottoNums.getNums();
    }


    public Rank getRank(List<LottoNum> winningLottoNum) {
        return new Rank(lottoNums.compareTo(winningLottoNum));
    }
}
