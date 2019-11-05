package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private final List<LottoNo> numbers;

    public Lotto(final List<Integer> numbers) {
        final List<LottoNo> lottoNos = new ArrayList<>();
        for (Integer number : numbers) {
            lottoNos.add(new LottoNo(number));
        }
        this.numbers = lottoNos;
    }

    Rank checkRank(final List<Integer> winNumbers, final int bonusNumber) {
        int countOfMatch = (int) numbers.stream().filter(number -> number.contains(winNumbers)).count();
        final boolean isMatchBonus = numbers.stream().anyMatch(number -> number.getNumber() == bonusNumber);

        if (countOfMatch == Rank.FOURTH.getCountOfMatch() && isMatchBonus) {
            countOfMatch = countOfMatch + 1;
        }

        return Rank.findByCountOfMatch(countOfMatch, isMatchBonus);
    }

    public List<Integer> findNumbers() {
        return this.numbers.stream()
                .map(LottoNo::getNumber)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
