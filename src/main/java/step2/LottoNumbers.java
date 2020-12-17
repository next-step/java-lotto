package step2;

import java.util.*;

public class LottoNumbers {

    private static final int LOTTO_NUMBER_COUNT = 6;
    private List<LottoNumber> nums;

    public LottoNumbers(LottoNumber... num) {
        this.nums = Arrays.asList(num);
        if (this.nums.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("Lotto must have 6 numbers");
        }
    }

    public LottoNumbers(List<LottoNumber> numbers) {
        this.nums = numbers;
        if (this.nums.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("Lotto must have 6 numbers");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers numbers = (LottoNumbers) o;
        return Objects.equals(nums, numbers.nums);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nums);
    }

    public MatchCount getMatchCount(LottoNumbers numbers2) {
        return new MatchCount(nums.stream()
                .filter(value -> numbers2.nums.contains(value))
                .count());
    }

    @Override
    public String toString() {
        return nums + "";
    }
}
