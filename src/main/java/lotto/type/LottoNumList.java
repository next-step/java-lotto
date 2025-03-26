package lotto.type;


import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumList {

  private final List<Integer> nums;

  private LottoNumList(List<Integer> nums) {
    this.nums = nums;
  }

  public static LottoNumList valueOf(List<Integer> nums) {
    return new LottoNumList(nums);
  }

  public int getMatchCount(WinningNums winningNums) {
    return (int) nums.stream()
        .filter(winningNums::contains).count();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoNumList that = (LottoNumList) o;
    return Objects.equals(nums, that.nums);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(nums);
  }

  @Override
  public String toString() {
    return nums.stream()
        .map(String::valueOf)
        .collect(Collectors.joining(", ", "[", "]"));
  }
}
