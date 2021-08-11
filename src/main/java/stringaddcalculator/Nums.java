package stringaddcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Nums {

    private final List<Integer> nums;

    private Nums(List<Integer> nums) {
        this.nums = nums;
    }

    public static Nums of(String[] splitNumsString) {
        List<Integer> numList = new ArrayList<>();
        for (String numString : splitNumsString) {
            int num = Integer.parseInt(numString);
            if (num < 0) {
                throw new RuntimeException("숫자는 0 이상이어야 합니다.");
            }
            numList.add(num);
        }
        return new Nums(numList);
    }

    public int sum() {
        return nums.stream().mapToInt(num -> num).sum();
    }

    public List<Integer> getNums() {
        return nums;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nums nums1 = (Nums) o;
        return Objects.equals(nums, nums1.nums);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nums);
    }

}
