package lotto.domain;

import lotto.utility.NumberMaker;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
  public static final int PRICE = 1000;

  public static final int LENGTH = 6;

  private final List<Integer> lottoNumber;

  // 번호 수동 입력
  public Lotto(List<Integer> numberList) {
    this.lottoNumber = new ArrayList<>(numberList);
  }

  // 당첨번호 확인
  public int matchLottoNumber(List<Integer> targetNumber) {
    return (int) targetNumber.stream().filter(this.lottoNumber::contains).count();
  }

  public boolean isMatchBonusNumber(int bonusNumber) {
    return this.lottoNumber.contains(bonusNumber);
  }

  public List<Integer> getCheckedNumbers() {
    return new ArrayList<>(this.lottoNumber);
  }
}
