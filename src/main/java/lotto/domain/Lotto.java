package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {
    private static final int LOTTO_NUMS = 6;
    private List<Integer> nums;

    public Lotto() {
        List<Integer> nums = Numbers.getNumbers();
        shuffleAndSort(nums);
    }

    public Lotto(List<Integer> nums) {
        shuffleAndSort(nums);
    }

    private void shuffleAndSort(List<Integer> nums) {
        Collections.shuffle(nums);
        this.nums = nums.stream().limit(LOTTO_NUMS).collect(Collectors.toList());
        Collections.sort(this.nums);
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

    public boolean contains(int num) {
        return nums.contains(num);
    }

}
