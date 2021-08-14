package step3.lotto.result;

import step3.lotto.Lotto;
import step3.lotto.LottoNumber;
import step3.lotto.Rank;
import step3.lotto.TotalLottoNumber;

public class LottoResult {

    private final Rank rank;

    public LottoResult(TotalLottoNumber winningNumber, Lotto lotto) {
        LottoNumber lottoNumber = lotto.getNumber();
        long countOfMatch = winningNumber.countOfMatch(lottoNumber);
        boolean matchBonus = winningNumber.matchBonus(lottoNumber);
        this.rank = Rank.valueOf(countOfMatch, matchBonus);
    }

    public Rank getRank() {
        return rank;
    }
}
