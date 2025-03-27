package lotto.type;


import lotto.LottoSystemConstants;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static lotto.LottoSystemConstants.LOTTO_MAX_NUM;
import static lotto.LottoSystemConstants.LOTTO_MIN_NUM;

public class LottoNumList {

  private final List<Integer> lottoNums;

  private LottoNumList(List<Integer> lottoNums) {
    if (new HashSet<>(lottoNums).size() != LottoSystemConstants.LOTTO_SIZE) {
      throw new IllegalArgumentException("로또 번호 수가 유효하지 않습니다.");
    }

    if (lottoNums.stream().anyMatch(num -> (num > LOTTO_MAX_NUM) || (num < LOTTO_MIN_NUM))) {
      throw new IllegalArgumentException("로또 번호가 유효하지 않습니다.");
    }
    this.lottoNums = lottoNums;
  }

  public static LottoNumList valueOf(List<Integer> lottoNums) {
    return new LottoNumList(lottoNums);
  }

  public int getMatchCount(WinningNums winningNums) {
    return (int) lottoNums.stream()
        .filter(winningNums::contains).count();
  }

  public boolean isMatch(BonusNum bonusNum) {
    return lottoNums.stream().anyMatch(bonusNum::isMatch);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoNumList that = (LottoNumList) o;
    return Objects.equals(lottoNums, that.lottoNums);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(lottoNums);
  }

  @Override
  public String toString() {
    return lottoNums.stream()
        .map(String::valueOf)
        .collect(Collectors.joining(", ", "[", "]"));
  }
}
