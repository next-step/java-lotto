package step2.domain;

import step2.exception.IsInvalidRangeException;

import java.util.Comparator;
import java.util.Objects;

import static step2.domain.WinningLottery.WINNING_NUMBER_INVALID_RANGE;

public class LottoNumber {

    private static final int LOTTO_BALL_START_NUMBER = 1;
    private static final int LOTTO_BALL_END_NUMBER = 45;
    private static final int IS_MATCHED = 1;
    private static final int IS_NOT_MATCHED = 0;

    private int number;

    public static class SortByLottoNumber implements Comparator<LottoNumber> {
        @Override
        public int compare(LottoNumber n1, LottoNumber n2) {
            return n1.getNumber() - n2.getNumber();
        }
    }

    /**
     * 개별 번호가 올바른 범위에 있는지 검사하는 메소드
     * @param number 개별 번호
     * @return LottoNumber 객체로 변환된 당첨 번호
     */
    public LottoNumber(int number) {
        if (number < LOTTO_BALL_START_NUMBER || number > LOTTO_BALL_END_NUMBER) {
            throw new IsInvalidRangeException(WINNING_NUMBER_INVALID_RANGE);
        }
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }

    /***
     * 현재 복권의 숫자와 당첨 번호가 같은지 비교하는 메소드
     * @param winningNumber 당첨 복권의 번호 (1)
     */
    public int compareNumber(LottoNumber winningNumber) {
        return (number == winningNumber.getNumber()) ? IS_MATCHED : IS_NOT_MATCHED;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
