package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningLotto {

    private static final String DELIMITER = ", ";

    private final Lotto lotto;
    private final LottoNumber bonus;

    public WinningLotto(Lotto lotto, LottoNumber bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public WinningLotto(List<Integer> numbers, int bonus) {
        this(new Lotto(numbers.stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList())), LottoNumber.from(bonus));
    }

    public WinningLotto(String numbers, int bonus) {
        this(Arrays.stream(numbers.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList()), bonus);
    }

    public LottoRank match(Lotto userLotto) {
        return LottoRank.valueOf(userLotto.countMatchingNumbers(lotto), userLotto.containBonus(bonus));
    }

    public LottoRank match(int... numbers) {
        return match(new Lotto(numbers));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(lotto, that.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotto);
    }
}
