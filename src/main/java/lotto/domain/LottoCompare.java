package lotto.domain;

import java.util.List;

public class LottoCompare {

    public Rank compareNumber(Lotto lotto, WinningLotto winNumber) {
        int count = winNumber.matchingCount(lotto);

        return Rank.valueOf(count, winNumber.isExistBonusBall(lotto));
    }

    public LottoResult match(List<Lotto> lotteries, WinningLotto winNumber) {
        LottoResult result = new LottoResult();

        for (Lotto oneTicket : lotteries) {
            result.calculateResult(compareNumber(oneTicket, winNumber));
        }
        return result;
    }

}
