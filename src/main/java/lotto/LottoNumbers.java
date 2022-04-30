package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {
    List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        this(new ArrayList<>());
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public List<LottoNumber> getLottoNumbers() {
        return Collections.unmodifiableList(lottoNumbers);
    }

    public void add(LottoNumber lottoNumber) {
        this.lottoNumbers.add(lottoNumber);
    }

    public int getQuantity() {
        return this.lottoNumbers.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        StringBuilder lottoNumbers = new StringBuilder();
        for (LottoNumber lottoNumber : this.lottoNumbers) {
            lottoNumbers.append(lottoNumber.toString()).append("\n");
        }
        return lottoNumbers.toString();
    }
}
