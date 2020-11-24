package lotto.domain;

import lotto.message.ErrorMessage;

import java.util.Collection;


public class LottoConstraint {
    private final int countOfNumber;
    private final int range;

    public LottoConstraint(int countOfNumber, int range) {
        this.countOfNumber = countOfNumber;
        this.range = range;
    }

    public int getCountOfNumber() {
        return countOfNumber;
    }

    public int getRange() {
        return range;
    }

    public void validate(Collection<Integer> balls) {
        if(countOfNumber != balls.size()){
            throw new RuntimeException(String.format(ErrorMessage.INVALID_BALL_COUNT_FORMAT, countOfNumber));
        }
        boolean rangeInvalid = balls.stream().anyMatch(ball -> range < ball);
        if(rangeInvalid){
            throw new RuntimeException(ErrorMessage.INVALID_BALL_NUMBER_RANGE);
        }
    }
}
