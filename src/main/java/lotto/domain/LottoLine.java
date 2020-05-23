package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoLine {

    private final LottoNums lottoNums;

    public LottoLine(LottoNums lottoNums) {
        this.lottoNums = lottoNums;
    }

    public Rank getRank(LottoNums lottoNums, LottoNum bonusNum) {
        return Rank
            .valueOf(this.lottoNums.getCountOfMatch(lottoNums), this.lottoNums.isContain(bonusNum));
    }

    public List<Integer> getNums() {
        return new ArrayList<>(this.lottoNums.toList());
    }
}
