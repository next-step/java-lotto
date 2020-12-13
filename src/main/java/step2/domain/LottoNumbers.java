package step2.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoNumbers {

    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public void checkWinningLotto(Number number) {
        lottoNumbers.stream()
                .forEach(lottoNumber -> lottoNumber.equalCheck(number));
    }

    public Map<Integer, Long> lottoWinningResult() {
        return lottoNumbers.stream()
                .collect(Collectors.groupingBy(LottoNumber::getCount, Collectors.counting()));
    }

    public List<LottoNumber> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumbers that = (LottoNumbers) o;

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
