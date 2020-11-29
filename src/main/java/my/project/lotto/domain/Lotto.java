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


    private final SortedSet<LottoNumber> lotto;

    public Lotto(List<LottoNumber> numbers) {
        this.lotto = new TreeSet<>(numbers);
        if (this.lotto.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUMBERS_HAVE_SIX);
        }
    }

    public Rank match(Lotto lastWinningLotto, LottoNumber bonusNumber) {
        int matchCount = (int) lotto.stream().filter(lastWinningLotto::contains).count();
        boolean matchBonus = lotto.contains(bonusNumber);
        return Rank.rank(matchCount, matchBonus);
    }

    public boolean contains(LottoNumber number) {
        return lotto.contains(number);
    }

    public SortedSet<LottoNumber> getLotto() {
        return lotto;
    }

}
