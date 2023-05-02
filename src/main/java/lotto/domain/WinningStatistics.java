package lotto.domain;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WinningStatistics {
    private static final Pattern NUMBER_PATTERN_COMPILE = Pattern.compile("^[0-9]+$");

    private final List<Integer> targetNumber;

    public WinningStatistics(String targetNumber) {
        this.targetNumber = convertNumberToList(targetNumber);
    }

    private List<Integer> convertNumberToList(String targetNumber) {
        List<Integer> numberList = Arrays.stream(targetNumber.split(", "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());
//        isThrowIllegalArgumentException(numberList);

        return numberList;
    }

    public List<Integer> compareWithTargetNumber(List<Lotto> lottoBundle) {
        return lottoBundle.stream()
                .map(lotto -> lotto.checkLottoNumber(this.targetNumber))
                .collect(Collectors.toList());
    }

    private boolean isNumber(String strNumber) {
        return NUMBER_PATTERN_COMPILE.asMatchPredicate().test(strNumber);
    }


    public List<Integer> showTargetNumber() {
        return new ArrayList<>(this.targetNumber);
    }
}
