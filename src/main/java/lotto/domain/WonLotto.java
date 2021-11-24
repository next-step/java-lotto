package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author han
 */
public class WonLotto {
    private final Map<Integer, LottoNumber> map;

    public WonLotto(Lotto lotto) {
        this.map = createMapBy(lotto);
    }

    public static WonLotto of(Lotto lotto) {
        return new WonLotto(lotto);
    }

    public Rank getLottoRankBy(Lotto lotto) {
        List<LottoNumber> numbers = lotto.getNumbers();
        int match = (int) numbers.stream()
            .mapToInt(LottoNumber::getNumber)
            .filter(map::containsKey)
            .count();
        return Rank.of(match);
    }

    private Map<Integer, LottoNumber> createMapBy(Lotto lotto) {
        return lotto.getNumbers()
            .stream()
            .collect(Collectors.toMap(LottoNumber::getNumber, p -> p));
    }
}
