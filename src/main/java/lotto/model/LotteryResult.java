package lotto.model;

import lotto.enums.Grade;

public final class LotteryResult {

  private final Grade grade;
  private final int count;

  public LotteryResult(Grade grade, int count) {
    this.grade = grade;
    this.count = count;
  }

  @Override
  public String toString() {
    return grade.getExpectNumber() + "개 일치"
        + "(" + grade.getAwardPrice() + ")" +
        "-" + count +"개";
  }
}
