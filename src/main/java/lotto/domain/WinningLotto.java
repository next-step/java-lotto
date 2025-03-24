package lotto.domain;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
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


    public LottoRank getRank(Lotto lotto) {
        return Arrays.stream(LottoRank.values())
            .filter(rank -> rank.match(this, lotto))
            .max(Comparator.comparing(LottoRank::getPrize))
            .orElseThrow();
    }
}
