package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoLine {

    private final LottoNums lottoNums;
    private boolean auto;

    public LottoLine(LottoNums lottoNums) {
        this(lottoNums, true);
    }

    public LottoLine(LottoNums lottoNums, boolean auto) {
        this.lottoNums = lottoNums;
        this.auto = auto;
    }

    public Rank getRank(LottoNums lottoNums, LottoNum bonusNum) {
        return Rank
            .valueOf(this.lottoNums.getCountOfMatch(lottoNums), this.lottoNums.isContain(bonusNum));
    }

    public boolean isAuto() {
        return auto;
    }

    public List<Integer> getNums() {
        return new ArrayList<>(this.lottoNums.toList());
    }
}
