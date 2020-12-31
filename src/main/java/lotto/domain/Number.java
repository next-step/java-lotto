package lotto.domain;

import util.CommonConstants;
import util.CommonException;
import util.Message;

public class Number implements Comparable<Number>{
    private int number;

    public Number(int number) {
        validateNumberRange(number);
    }

    private void validateNumberRange(int number) {
        if(CommonConstants.LOTTO_NUMBER_MIN > number || CommonConstants.LOTTO_NUMBER_MAX < number) {
            CommonException.IllegalArgumentException(Message.LOTTO_NUMBER_RANGE_EXCESS);
        }
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public boolean checkWinnerNumber(Number number, Integer winnerNumber) {
        return winnerNumber == number.getNumber();
    }

    @Override
    public int compareTo(Number number) {
        return Integer.compare(this.number, number.number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }
}
