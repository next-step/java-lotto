package lotto.domain;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private final List<LottoNumber> lottoBalls;
    private Rank rank;

    public Lotto(final List<LottoNumber> numberList) {
        this.lottoBalls = numberList;
    }

    public List<LottoNumber> getNumberList() {
        return Collections.unmodifiableList(lottoBalls);
    }

    public Rank getRank() {
        return rank;
    }

    public BigDecimal getAmount() {
        return rank.getAmount();
    }

    public Lotto matchRank(List<Integer> winnerNumberList, boolean matchBonus) {
        List<LottoNumber> winnerNumberListToCompare = matchNumberList(winnerNumberList);

        this.rank = Rank.getRank(
                (int) lottoBalls.stream()
                        .filter(winnerNumberListToCompare::contains)
                        .count()
                , matchBonus
        );

        return this;
    }

    private List<LottoNumber> matchNumberList(List<Integer> numberList) {
        return numberList.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    public int match() {
        return rank.getCount();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoBalls, lotto.lottoBalls) && rank == lotto.rank;
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoBalls, rank);
    }

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoBalls=" + lottoBalls +
                ", rank=" + rank +
                '}';
    }
}
