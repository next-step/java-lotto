package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningStatistics {
    private final List<Integer> targetNumber;

    public WinningStatistics(String lastNumber) {
        this.targetNumber = convertNumberToList(lastNumber);
    }

    private List<Integer> convertNumberToList(String lastNumber) {
        return Arrays.stream(lastNumber.split(", ")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public List<Integer> showTargetNumber() {
        return new ArrayList<>(this.targetNumber);
    }
}
