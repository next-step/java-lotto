package lotto.domain;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningStatistics {
    private static final Pattern NUMBER_PATTERN_COMPILE = Pattern.compile("^[0-9]+$");

    private final List<Integer> targetNumber;

    public WinningStatistics(List<Integer> targetNumber) {
        this.targetNumber = targetNumber;
    }



    public List<Integer> compareWithTargetNumber(List<Lotto> lottoBundle) {
        return lottoBundle.stream()
                .map(lotto -> lotto.checkLottoNumber(this.targetNumber))
                .collect(Collectors.toList());
    }

    public List<Integer> showTargetNumber() {
        return new ArrayList<>(this.targetNumber);
    }
}
