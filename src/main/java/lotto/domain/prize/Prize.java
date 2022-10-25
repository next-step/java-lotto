package lotto.domain.prize;

import lotto.domain.LottoNumber;

import java.util.List;

public class Prize {

    private final LottoMatch lottoMatch;
    private final EarningRatio earningRatio;

    public Prize(List<LottoNumber> pickNumbers, LottoNumber winningNumber, int money) {
        this.lottoMatch = new LottoMatch(pickNumbers, winningNumber);
        this.earningRatio = new EarningRatio(lottoMatch, money);
    }

    public LottoMatch getLottoMatch() {
        return lottoMatch;
    }

    public float getEarningRatio() {
        return earningRatio.getRatio();
    }
}
