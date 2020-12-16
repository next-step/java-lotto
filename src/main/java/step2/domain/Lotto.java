package step2.domain;

import java.util.List;

public class Lotto {

    private List<LottoNumber> lottoNumbers;
    private int count;

    public Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void equalCheck(LottoNumber lottoNumber) {
        if (lottoNumbers.contains(lottoNumber)) count++;
    }

    public List<LottoNumber> getNumbers() {
        return lottoNumbers;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lotto that = (Lotto) o;

        return lottoNumbers != null ? lottoNumbers.equals(that.lottoNumbers) : that.lottoNumbers == null;
    }

    @Override
    public int hashCode() {
        return lottoNumbers != null ? lottoNumbers.hashCode() : 0;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
