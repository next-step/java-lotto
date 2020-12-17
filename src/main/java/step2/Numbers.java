package step2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Numbers {

    private Set<Num> nums;

    public Numbers(Num... num) {
        this.nums = new HashSet<>(Arrays.asList(num));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Numbers numbers = (Numbers) o;
        return Objects.equals(nums, numbers.nums);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nums);
    }
}
