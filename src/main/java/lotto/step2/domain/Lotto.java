package lotto.step2.domain;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {
    private final Set<LottoNumber> nums;

    public Lotto(Set<Integer> nums) {
        validateSize(nums);

        this.nums = nums.stream()
                .map(LottoNumber::new)
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public Set<LottoNumber> nums() {
        return this.nums;
    }

    @Override
    public String toString() {
        return this.nums.toString();
    }

    private void validateSize(final Set<Integer> nums) {
        if (nums.size() != 6) {
            throw new IllegalArgumentException("lotto nums size must be 6");
        }
    }
}
