package lotto.domain;

import lotto.enums.MatchType;

import java.util.List;
import java.util.stream.Collectors;

public class Ticket {

    private List<Integer> numbers;

    public Ticket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public MatchType compareWinningLotto(WinningLotto winningLotto) {
        int count = getCountOfMatches(winningLotto.winningLottoStatus());

        if(MatchType.FIVE.isMatching(count) && hasBonus(winningLotto.findBonus()))
            return MatchType.BONUS;

        return MatchType.getMatchType(count, false);
    }

    //bonus에 대해 lotto no 객체를 추가해보는 것에 대해 고려, 1~45까지의 유효성 체크도 고려, 보너스번호는 1~45사이의 번호여야 하며, 6개의 값에 중복된 값이 있으면 안된다
    protected int getCountOfMatches(List<Integer> winningNumbers) {
        return (int) this.numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    private boolean hasBonus(int bonus) {
        return numbers.contains(bonus);
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(","));
    }
}
