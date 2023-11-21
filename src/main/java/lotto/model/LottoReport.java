package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoReport {
    private final List<Integer> result = new ArrayList<>(Collections.nCopies(7, 0));

    public LottoReport(String winningNumber, List<Lotto> tickets) {
        for (Lotto ticket : tickets) {
            addResult(winningNumber, ticket);
        }
    }

    private static List<Integer> convertStringToInt(String numbers) {
        return Arrays.stream(numbers.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void addResult(String number, Lotto ticket) {
        int matchCount = ticket.matchNumbers(convertStringToInt(number));
        this.result.set(matchCount, this.result.get(matchCount) + 1);
    }

    public List<Integer> result() {
        return this.result;
    }
}
