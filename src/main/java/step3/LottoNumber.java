package step3;

import step3.exception.inValidLottoNumberException;

import java.util.Objects;

public class LottoNumber implements Comparable<Integer> {

    private Integer number;

    public LottoNumber(int number) {
        checkIfValidLotto(number);

        this.number = number;
    }

    private void checkIfValidLotto(int number) {
        if(number < LottoConstants.BEG_LOTTO_NUM || number > LottoConstants.END_LOTTO_NUM) {
            throw new inValidLottoNumberException();
        }
    }

    @Override
    public int compareTo(Integer number) {
        return this.number.compareTo(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return Objects.equals(number, that.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    public Integer getNumber() {
        return this.number;
    }
}
