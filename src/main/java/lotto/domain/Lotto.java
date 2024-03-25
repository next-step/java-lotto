package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_PRICE = 1000;
    private List<LottoNumber> lotto;

    public Lotto() {
        this(LottoNumbers.issueNumbers());
    }

    public Lotto(List<LottoNumber> lotto) {
        validEmpty(lotto);
        this.lotto = lotto;
    }

    public static Lotto ofNumbers(List<Integer> lottoNumbers) {
        validEmpty(lottoNumbers);
        return new Lotto(lottoNumbers.stream().map(LottoNumber::new).collect(Collectors.toList()));
    }

    private static void validEmpty(List<?> lotto) {
        if (lotto == null || lotto.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다");
        }
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }

    public int size() {
        return lotto.size();
    }

    public int getFeatNumberCount(Lotto winLotto) {
        return (int) lotto.stream()
                .filter(value -> winLotto.getLotto().contains(value))
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
