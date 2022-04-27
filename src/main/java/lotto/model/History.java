package lotto.model;

import lotto.enums.Grade;

public final class History {
  private final Long reward;
  private final Grade grade;
  private final int count;

  public History(Long reward, Grade grade, int count) {
    this.reward = reward;
    this.grade = grade;
    this.count = count;
  }

  public Long getReward() {
    return reward;
  }

  public Grade getGrade() {
    return grade;
  }

  public int getCount() {
    return count;
  }
}
