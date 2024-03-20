package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {

    private List<Integer> subSet;

    public Lotto(List<Integer> pickedNumber) {
        this.subSet = pickedNumber;
    }

    public Lotto() {
        this(pickLottoNumber());
    }

    private static List<Integer> pickLottoNumber() {
        return createUniversalSet().stream().limit(6).sorted().collect(Collectors.toList());
    }

    private static List<Integer> createUniversalSet() {
        List<Integer> universalSet = IntStream.rangeClosed(1, 45).boxed().collect(Collectors.toList());
        Collections.shuffle(universalSet);
        return universalSet;
    }

    public int countMatchedNumber(Lotto otherLotto) {
        int count = 0;
        for (Integer num : subSet) {
            count = otherLotto.checkNumber(num, count);
        }
        return count;
    }

    private int checkNumber(Integer num, int count) {
        return isContained(this.subSet, num)? ++ count : count ;
    }

    private boolean isContained(List<Integer> lastWeekWin, Integer num) {
        return lastWeekWin.contains(num);
    }
}
