package step3.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private final LottoNumSet lottoNumSet;

    public Lotto(LottoNumSet lottoNumSet) {
        this.lottoNumSet = lottoNumSet;
    }

    public static Lotto of(int... lottoNums) {
        List<LottoNum> lottoNumList = Arrays.stream(lottoNums)
                .mapToObj(LottoNum::new)
                .collect(Collectors.toList());
        return new Lotto(new LottoNumSet(lottoNumList));
    }

    public int getMatchCount(Lotto other) {
        return (int) this.lottoNumSet.getLottoNumSet().stream()
                .filter(other.lottoNumSet::contains)
                .count();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumSet, lotto.lottoNumSet);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNumSet);
    }
}
