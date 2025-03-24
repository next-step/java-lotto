package lotto.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningLotto {
    private final Lotto lotto;

    public WinningLotto(List<Integer> numbers) {
        this.lotto = LottoFactory.createManual(numbers);
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return lotto.toString();
    }
}
