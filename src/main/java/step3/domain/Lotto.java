package step3.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private final LottoNums lottoNums;

    public Lotto(LottoNums lottoNums) {
        this.lottoNums = lottoNums;
    }

    public static Lotto of(int... lottoNums) {
        List<LottoNum> lottoNumList = Arrays.stream(lottoNums)
                .mapToObj(LottoNum::new)
                .collect(Collectors.toList());
        return new Lotto(new LottoNums(lottoNumList));
    }

    public Rank getRank(WinningLotto winningLotto) {
        int matchCount = getMatchCount(winningLotto.getWinningLotto());
        boolean matchBonus = containsBonus(winningLotto.getBonusNum());
        return Rank.valueOf(matchCount, matchBonus);
    }

    public List<LottoNum> sortedNumbers() {
        return new ArrayList<>(lottoNums.getLottoNums())
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public int getMatchCount(Lotto other) {
        return (int) this.lottoNums.getLottoNums().stream()
                .filter(other.lottoNums::contains)
                .count();
    }

    public boolean containsBonus(LottoNum bonusNum) {
        return this.lottoNums.contains(bonusNum);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNums, lotto.lottoNums);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lottoNums);
    }
}
