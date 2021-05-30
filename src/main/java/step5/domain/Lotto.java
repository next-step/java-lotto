package step5.domain;

import step5.exception.DuplicatedNumberException;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private final Set<LottoNumber> lotto;

    public Lotto(List<Integer> before) {
        this(toSet(before));
    }

    private static TreeSet<LottoNumber> toSet(List<Integer> before) {
        TreeSet<LottoNumber> lotto = new TreeSet<>();
        for (Integer no : before) {
            lotto.add(LottoNumber.of(no));
        }
        return lotto;
    }

    public Lotto(TreeSet<LottoNumber> before) {
        this.lotto = before;
        duplicatedCheck();
    }


    private void duplicatedCheck() {
        if (this.lotto.size() != LOTTO_SIZE) {
            throw new DuplicatedNumberException();
        }
    }

    public int match(Lotto winningLotto) {
        return (int) lotto.stream().filter(winningLotto::contains).count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public Set<LottoNumber> getLotto() {
        return lotto;
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lotto=" + lotto +
                '}';
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
