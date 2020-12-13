package step2.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoNumbers {

    private List<LottoNumber> lottoNumber;

    public LottoNumbers(List<LottoNumber> lottoNumber) {
        this.lottoNumber = lottoNumber;
    }

    public void checkWinningLotto(Number number) {
        lottoNumber.stream()
                .forEach(lottoNumber -> lottoNumber.equalCheck(number));
    }

    public Map<Integer, Long> winningResultMap() {
        return lottoNumber.stream()
                .collect(Collectors.groupingBy(LottoNumber::getCount, Collectors.counting()));
    }

    public List<LottoNumber> getLottoNumber() {
        return lottoNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumbers that = (LottoNumbers) o;

        return lottoNumber != null ? lottoNumber.equals(that.lottoNumber) : that.lottoNumber == null;
    }

    @Override
    public int hashCode() {
        return lottoNumber != null ? lottoNumber.hashCode() : 0;
    }

    @Override
    public String toString() {
        return lottoNumber.toString();
    }
}
