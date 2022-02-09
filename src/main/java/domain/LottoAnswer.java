package domain;

import java.util.List;

public class LottoAnswer {
    private final Lotto answer;
    private static final String MESSAGE_BONUS_RANGE_OVER = "(Error) 보너스 숫자의 범위를 넘어갔습니다.";
    private final int bonusNumber;

    public LottoAnswer(List<Integer> answerNumbers, int bonusNumber) {
        verifyBonus(bonusNumber);
        this.answer = Lotto.create(answerNumbers);
        this.bonusNumber = bonusNumber;
    }

    public LottoResult checkLottoAnswer(List<Lotto> lottoTickets) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottoTickets) {
            Rank rank = checkRank(lotto, lotto.countMatch(answer.getLotto()));
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

    private void verifyBonus(int bonusNumber) {
        if (bonusNumber < LottoGenerator.START_LOTTO_NUMBER || bonusNumber > LottoGenerator.END_LOTTO_NUMBER) {
            throw new IllegalArgumentException(MESSAGE_BONUS_RANGE_OVER);
        }
    }

}
