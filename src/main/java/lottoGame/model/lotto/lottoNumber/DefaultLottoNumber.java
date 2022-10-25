package lottoGame.model.lotto.lottoNumber;

import lottoGame.model.exception.InputException;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DefaultLottoNumber implements LottoNumber {
    private static final int MAX = 45;
    private static final int MIN = 1;
    private static final List<LottoNumber> lottoNumbers = IntStream.range(MIN, MAX)
            .mapToObj(DefaultLottoNumber::new)
            .collect(Collectors.toList());
    private int lottoNumber;

    public DefaultLottoNumber(int lottoNum) {
        validateNum(lottoNum);
        this.lottoNumber = lottoNum;
    }

    public static List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public void validateNum(int input) {
        checkMax(input);
        checkMin(input);
    }

    @Override
    public boolean isMatchOrNot(int lottoNum) {
        return lottoNumber == lottoNum;
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
