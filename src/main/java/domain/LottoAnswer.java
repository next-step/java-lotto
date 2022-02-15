package domain;

import java.util.List;

public class LottoAnswer {
    private final Lotto answer;
    private final LottoNumber bonusNumber;

    public LottoAnswer(List<LottoNumber> answerNumbers, LottoNumber bonusNumber) {
        bonusNumber.verify(bonusNumber);
        this.answer = Lotto.create(answerNumbers);
        this.bonusNumber = bonusNumber;
    }

    public LottoResult checkLottoAnswer(List<Lotto> lottoTickets) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottoTickets) {
            Rank rank = checkRank(lotto, lotto.countMatch(answer));
            lottoResult.addRankCount(rank);
        }
        return lottoResult;
    }

    private Rank checkRank(Lotto lotto, int matchCount) {
        if (Rank.isBonusCriteria(matchCount)) {
            return Rank.getBonusRank(matchCount, lotto.checkBonus(bonusNumber));
        }
        return Rank.getRank(matchCount);
    }


}
