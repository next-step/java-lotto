package lotto.domain;

import java.util.*;
import java.util.regex.Pattern;

public class WinningStatistics {
    private static final Pattern NUMBER_PATTERN_COMPILE = Pattern.compile("^[0-9]+$");

    private final List<Integer> targetNumber;

    public WinningStatistics(List<Integer> targetNumber) {
        this.targetNumber = targetNumber;
    }

//    public Map<Integer, Long> convertMapType(List<Integer> lottoResult ) {
//        return lottoResult.stream()
//            .collect(Collectors.groupingBy( arg -> arg, HashMap::new, Collectors.counting()));
//    }

    public void compareWithTargetNumber(List<Lotto> lottoBundle) {
        for(Lotto lotto : lottoBundle) {
            lotto.matchLottoNumber(this.targetNumber);
        }

//        lottoBundle.stream().map(lotto -> lotto.matchLottoNumber(this.targetNumber));
//                                            .sorted()
//                                            .collect(Collectors.toList());

    }

    public List<Integer> showTargetNumber() {
        return new ArrayList<>(this.targetNumber);
    }
}
