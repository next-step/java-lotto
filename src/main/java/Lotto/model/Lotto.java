package Lotto.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private static final int PROPER_LOTTONUMBER_COUNT = 6;
    private static final String LOTTO_COUNT_ERROR_MESSAGE = "로또번호는 6개입니다.";
    private List<LottoNumber> lotto;

    public Lotto(List<LottoNumber> lotto) {
        validate(lotto);
        this.lotto = lotto;
    }

    private void validate(List<LottoNumber> lotto) {
        if (lotto.stream().distinct().collect(Collectors.toList()).size() != PROPER_LOTTONUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_COUNT_ERROR_MESSAGE);
        }
    }

    public int countMatchNumbers(Lotto luckyNumber) {
        return (int) lotto.stream()
                .filter(it -> luckyNumber.isContain(it))
                .count();
    }

    public boolean isContain(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(getLotto(), lotto1.getLotto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLotto());
    }
}
