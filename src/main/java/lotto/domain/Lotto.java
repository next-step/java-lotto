package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_NUMS = 6;
    private List<Integer> nums;
    private List<Integer> numberRange = Numbers.getNumbers();

    public Lotto() {
        Collections.shuffle(numberRange);
        nums = numberRange.stream().limit(LOTTO_NUMS).collect(Collectors.toList());
    }

    public List<Integer> getNums() {
        return nums;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lotto)) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(nums, lotto.nums);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nums);
    }
}
