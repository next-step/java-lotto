package lotto.domain;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    public static final int LOTTO_PRICE = 1000;
    private Set<LottoNumber> lotto;

    public Lotto() {
        this(LottoNumbers.issueNumbers());
    }

    public Lotto(Set<LottoNumber> lotto) {
        validEmpty(lotto);
        validLottoSize(lotto);
        this.lotto = lotto;
    }

    public static Lotto ofNumbers(Set<Integer> lottoNumbers) {
        validEmpty(lottoNumbers);
        return new Lotto(lottoNumbers.stream().map(LottoNumber::new).collect(Collectors.toSet()));
    }

    private static void validEmpty(Set<?> lotto) {
        if (lotto == null || lotto.isEmpty()) {
            throw new IllegalArgumentException("입력값이 없습니다");
        }
    }

    private static void validLottoSize(Set<?> lotto) {
        if(lotto.size() != 6) {
            throw new IllegalArgumentException("유효한 Lotto size가 아닙니다: " + lotto.size());
        }
    }

    public Set<LottoNumber> getLotto() {
        return lotto;
    }

    public int size() {
        return lotto.size();
    }

    public boolean isContainBonus(LottoNumber bonus) {
        return lotto.contains(bonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
