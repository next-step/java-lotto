package step2.domain.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoNumbers {
    private final Set<Integer> lottoNumbers;

    public LottoNumbers(Set<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers findIntersection(List<Integer> list1, List<Integer> list2) {
        Set<Integer> intersection = new HashSet<>(list1);
        Set<Integer> list2Set = new HashSet<>(list2);
        intersection.retainAll(list2Set);
        return new LottoNumbers(intersection);
    }

    public static LottoNumbers findDifference(List<Integer> list1, List<Integer> list2) {
        Set<Integer> difference = new HashSet<>(list1);
        Set<Integer> list2Set = new HashSet<>(list2);
        difference.removeAll(list2Set);
        return new LottoNumbers(difference);
    }

    public int size() {
        return lottoNumbers.size();
    }

    public boolean contains(Integer number) {
        return lottoNumbers.contains(number);
    }
}
