package domain;

import java.util.List;

public class AnswerLotto {
    public static final String MESSAGE_INPUT_ANSWER_NUMBER_COUNT_OVER = "[오류] 숫자를 6개 이상 입력하셨습니다.";
    public static final String MESSAGE_INPUT_ANSWER_NUMBER_RANGE_OVER = "[오류] 숫자의 범위를 넘어갔습니다.";
    private final List<Integer> answerNumbers;
    private final int bonusNumber;

    public AnswerLotto(List<Integer> answerNumbers, int bonusNumber) {
        checkInputNumberCount(answerNumbers);
        checkNumberRange(answerNumbers, bonusNumber);
        this.answerNumbers = answerNumbers;
        this.bonusNumber = bonusNumber;
    }

    public LottoResult checkLottoAnswer(List<Lotto> lottoTickets) {
        LottoResult lottoResult = new LottoResult();
        for (Lotto lotto : lottoTickets) {
            int matchNumberCount = lotto.countMatchCount(answerNumbers);
            Rank rank = Rank.getRank(matchNumberCount, lotto.checkBonusNumber(bonusNumber));
            lottoResult.addRankCount(rank);
        }
        return lottoResult;
    }

    private void checkInputNumberCount(List<Integer> answerNumbers) {
        if (!checkInputNumberCountCondition(answerNumbers)) {
            throw new IllegalArgumentException(MESSAGE_INPUT_ANSWER_NUMBER_COUNT_OVER);
        }
    }

    private void checkNumberRange(List<Integer> answerNumbers, int bonusNumber) {
        if (!checkAnswerNumberRangeCondition(answerNumbers) || !checkBonusNumberRangeCondition(bonusNumber)) {
            throw new IllegalArgumentException(MESSAGE_INPUT_ANSWER_NUMBER_RANGE_OVER);
        }
    }

    private boolean checkInputNumberCountCondition(List<Integer> answerNumbers) {
        return answerNumbers.size() == LottoGenerator.COUNT_LOTTO_NUMBER;
    }

    private boolean checkAnswerNumberRangeCondition(List<Integer> answerNumbers) {
        //noneMatch : 조건에 부합하는 객체가 없어야 true 아니면 false 리턴
        return answerNumbers.stream()
                .noneMatch(number -> number > LottoGenerator.END_LOTTO_NUMBER || number < LottoGenerator.START_LOTTO_NUMBER);
    }

    private boolean checkBonusNumberRangeCondition(int bonusNumber) {
        return (LottoGenerator.START_LOTTO_NUMBER <= bonusNumber && bonusNumber <= LottoGenerator.END_LOTTO_NUMBER);
    }

}
