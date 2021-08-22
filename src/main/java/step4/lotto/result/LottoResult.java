package step4.lotto.result;

import step4.lotto.Lotto;
import step4.lotto.LottoNumber;
import step4.lotto.Rank;
import step4.lotto.TotalLottoNumber;

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

    public long getPrizeMoney() {
        return rank.getPrizeMoney();
    }
}
