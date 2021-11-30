package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author han
 */
public class WonLotto {
    private final Map<Integer, LottoNumber> map;
    private final LottoNumber bonus;

    public WonLotto(Lotto lotto, LottoNumber bonus) {
        this.map = createMapBy(lotto);
        this.bonus = bonus;
    }

    public static WonLotto of(Lotto lotto, LottoNumber bonus) {
        return new WonLotto(lotto, bonus);
    }

    public Rank getLottoRankBy(Lotto lotto) {
        List<LottoNumber> numbers = lotto.getNumbers();
        int match = (int) numbers.stream()
            .mapToInt(LottoNumber::getNumber)
            .filter(map::containsKey)
            .count();
        return Rank.of(match, numbers.contains(bonus));
    }

    private Map<Integer, LottoNumber> createMapBy(Lotto lotto) {
        return lotto.getNumbers()
            .stream()
            .collect(Collectors.toMap(LottoNumber::getNumber, p -> p));
    }
}
