package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;


public class Lotto {

    private static final String DELIMITER = ", ";
    private Set<Number> nums;

    public Lotto() {
        this.nums = Number.initialNumber();
    }

    public Lotto(List<Integer> inputNums) {
        this.nums = inputNums.stream()
                            .map(Number::of)
                            .collect(Collectors.toSet());
    }

    public Lotto(String inputNums) {
        this.nums = splitLotto(inputNums);
    }

    private Set<Number> splitLotto(String nums) {
        return Arrays.stream(nums.split(DELIMITER))
                .map(Number::of).collect(Collectors.toSet());
    }

    public Rank calculateRank(Lotto lotto, Number bounsNum) {
        boolean isBonus = lotto.nums.contains(bounsNum);
        lotto.nums.retainAll(this.nums);
        return Rank.of(lotto.nums.size(), isBonus);
    }

    public Set<Number> getNums() {
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
