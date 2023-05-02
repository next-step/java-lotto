package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class WinningStatistics {
    private final List<Integer> targetNumber;

    public WinningStatistics(String lastNumber) {
        this.targetNumber = convertNumberToList(lastNumber);
    }

    private List<Integer> convertNumberToList(String lastNumber) {
        return Arrays.stream(lastNumber.split(", ")).map(Integer::parseInt).collect(Collectors.toList());
    }

    public List<Integer> compareWithLastNumber(List<Lotto> lottoBundle) {
        return lottoBundle.stream()
                .map(lotto -> lotto.checkLottoNumber(this.targetNumber))
                .collect(Collectors.toList());
    }
//
//    private int  isContainsTarget(List<Integer> lotto) {
//        return (int) this.targetNumber.stream()
//                .filter(target -> lotto.contains(target))
//                .count();
//    }

    public List<Integer> showTargetNumber() {
        return new ArrayList<>(this.targetNumber);
    }
}
