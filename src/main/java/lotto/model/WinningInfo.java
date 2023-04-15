package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningInfo {

    public List<Integer> winningLottos;
    public int bonusNumber;

    public WinningInfo(String winningLottos, int bonusNumber) {
        this.winningLottos = parseNumbers(winningLottos);
        this.bonusNumber = bonusNumber;
    }

    public static List<Integer> parseNumbers(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(o -> Integer.parseInt(o.trim()))
                .collect(Collectors.toList());
    }
}
