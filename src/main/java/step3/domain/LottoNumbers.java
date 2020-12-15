package step3.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoNumbers {

    private List<Lotto> lotto;

    public LottoNumbers(List<Lotto> lotto) {
        this.lotto = lotto;
    }

    public void checkWinningLotto(LottoNumber number) {
        lotto.stream()
                .forEach(lottoNumber -> lottoNumber.equalCheck(number));
    }

    public Map<Integer, Long> winningResultMap() {
        return lotto.stream()
                .collect(Collectors.groupingBy(Lotto::getCount, Collectors.counting()));
    }

    public List<Lotto> getLottoNumber() {
        return lotto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LottoNumbers that = (LottoNumbers) o;

        return lotto != null ? lotto.equals(that.lotto) : that.lotto == null;
    }

    @Override
    public int hashCode() {
        return lotto != null ? lotto.hashCode() : 0;
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
