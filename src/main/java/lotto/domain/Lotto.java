package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private List<Integer> nums;

    private Lotto() {
        List<Integer> numArr = new ArrayList<>();
        for(int i = 1; i<46; i++) {
            numArr.add(i);
        }
        Collections.shuffle(numArr);
        nums = numArr.stream().limit(6).collect(Collectors.toList());
    }

    public static Lotto of() {
        return new Lotto();
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
