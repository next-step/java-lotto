package domain;

import java.util.Collections;
import java.util.List;

public class AnswerLotto {
    private final List<Integer> answerLotto;
    public static final String MESSAGE_INPUT_ANSWER_NUMBER_COUNT_OVER = "[오류] 숫자를 6개 이상 입력하셨습니다.";
    public static final String MESSAGE_INPUT_ANSWER_NUMBER_RANGE_OVER = "[오류] 숫자의 범위를 넘어갔습니다.";

    public AnswerLotto(List<Integer> answerLotto) {
        checkInputNumberCount(answerLotto);
        checkNumberRange(answerLotto);
        this.answerLotto = answerLotto;
    }

    public List<Integer> getAnswerLotto() {
        return Collections.unmodifiableList(answerLotto);
    }

    public void checkInputNumberCount(List<Integer> answerNumbers) {
        if (!checkInputNumberCountCondition(answerNumbers)) {
            throw new IllegalArgumentException(MESSAGE_INPUT_ANSWER_NUMBER_COUNT_OVER);
        }
    }

    public void checkNumberRange(List<Integer> answerNumbers) {
        if (!checkNumberRangeCondition(answerNumbers)) {
            throw new IllegalArgumentException(MESSAGE_INPUT_ANSWER_NUMBER_RANGE_OVER);
        }
    }

    public boolean checkInputNumberCountCondition(List<Integer> answerNumbers) {
        return answerNumbers.size() == LottoGenerator.COUNT_LOTTO_NUMBER;
    }

    public boolean checkNumberRangeCondition(List<Integer> answerNumbers) {
        return answerNumbers.stream()
                .noneMatch(number -> number > LottoGenerator.END_LOTTO_NUMBER || number < LottoGenerator.START_LOTTO_NUMBER);
    }


}
