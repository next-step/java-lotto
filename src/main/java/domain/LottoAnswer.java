package domain;

import java.util.List;

public class LottoAnswer {
    private final Lotto answer;
    public static final String MESSAGE_INPUT_ANSWER_NUMBER_COUNT_OVER = "[오류] 숫자를 6개 이상 입력하셨습니다.";
    public static final String MESSAGE_INPUT_ANSWER_NUMBER_RANGE_OVER = "[오류] 숫자의 범위를 넘어갔습니다.";
    private final int bonusNumber;

    public LottoAnswer(List<Integer> answerNumbers, int bonusNumber) {
        verifyBonus(bonusNumber);
        this.answer = Lotto.create(answerNumbers);
        this.bonusNumber = bonusNumber;
    }

    public LottoResult checkLottoAnswer(List<Lotto> lottoTickets) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottoTickets) {
            Rank rank = checkBonus(lotto, lotto.countMatch(answer.getLotto()));
            lottoResult.addRankCount(rank);
        }
        return lottoResult;
    }

    private Rank checkBonus(Lotto lotto, int matchCount) {
        if (Rank.BonusCriteria(matchCount)) {
            return Rank.getRank(matchCount, lotto.checkBonus(bonusNumber));
        }
        return Rank.getRank(matchCount);
    }

    private void verifyBonus(int bonusNumber) {
        if (bonusNumber < LottoGenerator.START_LOTTO_NUMBER || bonusNumber > LottoGenerator.END_LOTTO_NUMBER) {
            throw new IllegalArgumentException(MESSAGE_INPUT_ANSWER_NUMBER_RANGE_OVER);
        }
    }

}
