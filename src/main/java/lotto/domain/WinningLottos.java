package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottos {
    List<Integer> winningNumbers;

    public WinningLottos(String strNumbers) {
        this.winningNumbers = Arrays.stream(strNumbers.split(","))
                                    .map(Integer::parseInt)
                                    .collect(Collectors.toList());
    }
}
