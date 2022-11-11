package step2_pobi.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private static final String EXCEPTION_MESSAGE_SIZE = "로또는 6개의 값이어야 합니다.";

    private final Set<LottoNumber> lotto;

    public Lotto(List<Integer> lottoList) {
        this(toSet(lottoList));
    }

    private static Set<LottoNumber> toSet(List<Integer> lottoList) {
        Set<LottoNumber> lotto = new HashSet<>();
        for (Integer no : lottoList) {
            lotto.add(LottoNumber.of(no));
        }
        return lotto;
    }

    public Lotto(Set<LottoNumber> lottoList) {
        this.lotto = lottoList;
        if (this.lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_SIZE);
        }
    }

    public int match(Lotto winningLotto) {
        int count = 0;
        for (LottoNumber lottoNumber : lotto) {
            if (winningLotto.contains(lottoNumber)) {
                count += 1;
            }
        }
        return count;
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public List<Integer> getLotto() {
        return null;
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

    @Override
    public String toString() {
        return "Lotto{" +
                "lotto=" + lotto +
                '}';
    }
}