package lotto.domain;

import lotto.utils.GenerateLotto;

import java.util.List;
import java.util.Objects;

import static java.util.stream.Collectors.toList;

public class Lotto {

    private List<LottoNo> number;

    public Lotto() {
        this.number = GenerateLotto.create();
    }

    public Lotto(final String number) {
        this.number = GenerateLotto.create(number);
    }

    public List<LottoNo> getNumber() {
        return number;
    }

    public boolean lottoOfRank(final Lotto lotto, final Rank rank, final int bonus) {
        return isSecondRank(rank, bonus) ? eqCountOfMatch(lotto, rank) && eqBonus(bonus) : eqCountOfMatch(lotto, rank);
    }

    private boolean eqCountOfMatch(final Lotto lotto, final Rank rank) {
        return calculatorLottoNumberMatchScore(lotto) == rank.getCountOfMatch();
    }

    private boolean eqBonus(final int bonus) {
        return getNumber().stream()
                .filter(number -> LottoNo.eqBonus(number, bonus))
                .collect(toList()).size() > 0;
    }

    private boolean isSecondRank(final Rank rank, final int bonus) {
        return Rank.valueOf(rank.getCountOfMatch(), eqBonus(bonus)).equals(Rank.SECOND);
    }

    private int calculatorLottoNumberMatchScore(final Lotto lotto) {
        return sumNumberMatchCheckLoop(0, lotto.getNumber());
    }

    @SuppressWarnings("SameParameterValue")
    private int sumNumberMatchCheckLoop(int matchScore, final List<LottoNo> number) {
        for (LottoNo num : number) {
            matchScore = numberMatchCheckLoop(matchScore, num);
        }
        return matchScore;
    }

    private int numberMatchCheckLoop(int matchScore, final LottoNo numbers) {
        for (LottoNo num : getNumber()) {
            matchScore = eqCheckLottoNumber(matchScore, numbers, num);
        }
        return matchScore;
    }

    private int eqCheckLottoNumber(int matchScore, final LottoNo sourceNumber, final LottoNo targetNumber) {
        if (sourceNumber.equals(targetNumber)) {
            matchScore = increaseMatchScore(matchScore);
        }
        return matchScore;
    }

    private int increaseMatchScore(int matchScore) {
        matchScore++;
        return matchScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(number, lotto.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

}
