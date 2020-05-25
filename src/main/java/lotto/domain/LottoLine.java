package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoLine {

    private final LottoNums lottoNums;
    private boolean auto;

    private LottoLine(LottoNums lottoNums, boolean auto) {
        this.lottoNums = lottoNums;
        this.auto = auto;
    }

    static LottoLine newAuto() {
        return new LottoLine(LottoNumsGenerator.generate(), true);
    }

    static LottoLine newManual(LottoNums lottoNums) {
        return new LottoLine(lottoNums, false);
    }

    public List<Integer> getNums() {
        return new ArrayList<>(this.lottoNums.toList());
    }

    boolean isAuto() {
        return auto;
    }

    boolean isManual() {
        return !isAuto();
    }

    Rank getRank(LottoNums lottoNums, LottoNum bonusNum) {
        return Rank
            .valueOf(this.lottoNums.getCountOfMatch(lottoNums), this.lottoNums.isContain(bonusNum));
    }
}
