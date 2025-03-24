package lotto.type;

import lotto.property.LottoProperty;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumList {

  private final List<Integer> nums;

  public LottoNumList(List<Integer> nums) {
    if (new HashSet<>(nums).size() != LottoProperty.LOTTO_NUM_SIZE) {
      throw new IllegalArgumentException("유효하지 않은 숫자 수입니다.");
    }
    this.nums = nums;
  }

  public int getMatchCount(List<Integer> winningNums) {
    if (new HashSet<>(winningNums).size() != LottoProperty.LOTTO_NUM_SIZE) {
      throw new IllegalArgumentException("당첨 번호가 유효하지 않은 숫자 수입니다.");
    }
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
