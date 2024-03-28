package lotto.domain;

import java.util.List;

public class AnswerSheet {

    private final List<Integer> numbers;
    private final Integer bonusNumber;

    public AnswerSheet(List<Integer> numbers, String bonusNumber) {
        this(numbers, Integer.parseInt(bonusNumber));
    }

    public AnswerSheet(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.size() != Lotto.LOTTO_NUMBER_LIMIT)
            throw new IllegalArgumentException("정답 넘버는 6개여야합니다, 주어진 넘버는 " + numbers.size());
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public List<Integer> getAnswerNumbers(){
        return this.numbers;
    }

    public Integer getBonusNumber(){
        return this.bonusNumber;
    }
}
