package lotto.automatic.domain;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {

    private static final int NUMS_SIZE = 6;
    private final Set<Integer> nums;

    public Lotto(List<Integer> nums) {
        validate(nums);

        this.nums = new TreeSet<>(nums);

    }

    private void validate(List<Integer> nums) {

        if (nums.stream()
                .filter((Integer num) -> (num > 0 && num < 46))
                .count() != NUMS_SIZE
        ) {
            throw new IllegalArgumentException("로또 번호는 1과 45 사이의 숫자 6개로 구성되어 있어야 합니다.");
        }
    }

    public boolean contain(int i) {

        return nums.contains(i);
    }

    public int matchCount(Lotto winnerLotto) {
        int count = 0;
        for (int num : nums) {
            count += winnerLotto.contain(num) ? 1 : 0;
        }
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lotto lotto = (Lotto) o;

        return nums != null ? nums.equals(lotto.nums) : lotto.nums == null;
    }

    @Override
    public int hashCode() {
        return nums != null ? nums.hashCode() : 0;
    }

    @Override
    public String toString() {
        return nums.toString();
    }
}
