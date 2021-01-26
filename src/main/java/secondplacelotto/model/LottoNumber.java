package secondplacelotto.model;

import secondplacelotto.exception.IsNotScopeInTheNumberException;

public class LottoNumber {

    private final int number;

    public LottoNumber(int number) {
        if (!(1 <= number && number <= 45)) {
            throw new IsNotScopeInTheNumberException("로또 번호는 1부터 45까지의 숫자만 가능합니다");
        }

        this.number = number;
    }

    public boolean isMatchBonusNumber(LottoNumber lottoNumber, int matchingCount) {
        return lottoNumber.number == number && matchingCount == 5;
    }

    public int matchNumber(LottoNumber winningNumber) {
        if (number == winningNumber.number) {
            return 1;
        }

        return 0;
    }

    public int viewNumber() {
        return number;
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
        return number;
    }
}
