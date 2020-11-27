package my.project.lotto.domain;

import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created : 2020-11-27 오전 9:54
 * Developer : Seo
 */
public class Lotto {
    public static final int LOTTO_SIZE = 6;
    private final SortedSet<Integer> lotto;

    public Lotto(List<Integer> lotto) {
        this.lotto = new TreeSet<>(lotto);
        if (this.lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 한 장은 6개 번호입니다.");
        }
        if (this.lotto.first() < 1) {
            throw new IllegalArgumentException("로또 번호는 1과 45 사이입니다.");
        }
        if (this.lotto.last() > 45) {
            throw new IllegalArgumentException("로또 번호는 1과 45 사이입니다.");
        }
    }

    public Rank match(Lotto winningLotto) {
        int matchCount = (int) lotto.stream().filter(i -> winningLotto.contains(i)).count();
        return Rank.rank(matchCount, false);
    }

    public boolean contains(Integer number) {
        return lotto.contains(number);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Integer i : lotto) {
            sb.append(", ").append(i);
        }
        sb.append(" ]");
        return sb.toString().replaceFirst(",", "");
    }
}
