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
    public static final String LOTTO_NUMBERS_HAVE_SIX = "로또 한 장은 6개 번호입니다.";
    public static final String LOTTO_NUMBER_IS_BETWEEN = "로또 번호는 1과 45 사이입니다.";
    private final SortedSet<Integer> lotto;

    public Lotto(List<Integer> numbers) {
        this.lotto = new TreeSet<>(numbers);
        if (this.lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_HAVE_SIX);
        }
        if (this.lotto.first() < 1) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_BETWEEN);
        }
        if (this.lotto.last() > 45) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_BETWEEN);
        }
    }

    public Rank match(Lotto lastWinningLotto, int bonusNumber) {
        if (bonusNumber < 1) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_BETWEEN);
        }
        if (bonusNumber > 45) {
            throw new IllegalArgumentException(LOTTO_NUMBER_IS_BETWEEN);
        }

        int matchCount = (int) lotto.stream().filter(lastWinningLotto::contains).count();
        boolean matchBonus = lotto.stream().anyMatch(integer -> bonusNumber == integer);
        return Rank.rank(matchCount, matchBonus);
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
