package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoReport {

    public static void checkLottoResult(String winningNumber, List<Lotto> tickets) {
        for (Lotto ticket : tickets) {
            ticket.matchNumbers(convertStringToInt(winningNumber));
        }
    }

    private static List<Integer> convertStringToInt(String numbers) {
        return Arrays.stream(numbers.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
