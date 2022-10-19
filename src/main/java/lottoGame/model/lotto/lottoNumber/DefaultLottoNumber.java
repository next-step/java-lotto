package lottoGame.model.lotto.lottoNumber;

import lottoGame.model.exception.InputException;

import java.util.Objects;

public class DefaultLottoNumber implements LottoNumber {
    public static final int MAX = 45;
    public static final int MIN = 1;
    private int lottoNumber;

    public DefaultLottoNumber(int lottoNum) {
        validateNum(lottoNum);
        this.lottoNumber = lottoNum;
    }

    @Override
    public void validateNum(int input) {
        checkMax(input);
        checkMin(input);
    }

    @Override
    public boolean isMatchOrNot(int winningNumber) {
        return lottoNumber == winningNumber;
    }

    public int getLottoNumber() {
        return lottoNumber;
    }

    private void checkMax(int input) {
        if (input > MAX) {
            throw new InputException("입력 값이 최대 값보다 큽니다.");
        }
    }

    private void checkMin(int input) {
        if (input < MIN) {
            throw new InputException("입력 값이 최소 값보다 작습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DefaultLottoNumber that = (DefaultLottoNumber) o;
        return lottoNumber == that.lottoNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }

    @Override
    public String toString() {
        return "" + lottoNumber + "";
    }
}
