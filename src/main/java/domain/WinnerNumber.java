package domain;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinnerNumber {

    private Set<Integer> winnerNumber;
    private int bonusNumber;

    public WinnerNumber(String[] number, int bonus) {
        new ValidateWinnerNumber(number, bonus);

        winnerNumber = Stream.of(number).mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toSet());

        bonusNumber = bonus;
    }

    int getCountingNumber(Lotto lotto) {
        int count = (int) lotto.getLottoNumber()
                .stream()
                .filter(winnerNumber::contains)
                .count();

        return count;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Set<Integer> getWinnerNumber() {
        return winnerNumber;
    }
}
