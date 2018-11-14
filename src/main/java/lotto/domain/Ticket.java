package lotto.domain;

import lotto.enums.MatchType;

import java.util.List;
import java.util.stream.Collectors;

public class Ticket {

    private List<LottoNo> numbers;

    public Ticket(List<LottoNo> numbers) {
        this.numbers = numbers;
    }

    public List<LottoNo> getNumbers() {
        return this.numbers;
    }

    public MatchType compareWinningLotto(WinningLotto winningLotto) {
        int count = winningLotto.winningLottoStatus()
                .stream()
                .mapToInt(this::getCountOfMatches)
                .sum();

        if(MatchType.FIVE.isMatching(count) && hasBonus(winningLotto.findBonus()))
            return MatchType.BONUS;

        return MatchType.getMatchType(count, false);
    }

    int getCountOfMatches(LottoNo number) {
        return (int)this.numbers
                .stream()
                .filter(n -> n.compareTo(number) == 0)
                .count();
    }

    private boolean hasBonus(LottoNo bonus) {
        return this.numbers
                .stream()
                .anyMatch(n -> n.compareTo(bonus) == 0);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }
}
