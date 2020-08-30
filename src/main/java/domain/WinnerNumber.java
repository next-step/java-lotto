package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinnerNumber {

    private List<Integer> winnerNumber;
    private int bonusNumber;

    public WinnerNumber(String[] number, int bonus) {
        new ValidateWinnerNumber(number);

        //todo
        // bouns validate



        winnerNumber = Stream.of(number).mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());

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

    public List<Integer> getWinnerNumber() {
        return winnerNumber;
    }
}
