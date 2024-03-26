package lotto.domain;

import java.util.List;

public class AnswerSheet {

    private final List<Integer> numbers;
    private final Integer bonusNumber;

    public AnswerSheet(List<Integer> numbers, String bonusNumber) {
       this(numbers,Integer.parseInt(bonusNumber));
    }
    public AnswerSheet(List<Integer> numbers, Integer bonusNumber) {
        if(numbers.size() != 6)
            throw new IllegalArgumentException("정답 넘버는 6개여야합니다.");
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public int matchCount(Lotto lotto){
        return lotto.countMatchNumbers(numbers);
    }
    public boolean matchBonus(Lotto lotto){
        return lotto.containsNumber(bonusNumber);
    }

}
