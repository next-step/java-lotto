package domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WinnerNumber {

    private List<Integer> winnerNumber;

    public WinnerNumber(String[] number) {
        new ValidateWinnerNumber(number);

        winnerNumber = Stream.of(number).mapToInt(Integer::parseInt)
                .boxed().collect(Collectors.toList());
    }

    int getCountingNumber(Lotto lotto) {
        int count = lotto.getLottoNumber().stream().filter(winnerNumber::contains)
                .collect(Collectors.toList()).size();

        return count;
    }
}
