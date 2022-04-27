package lotto.model;

import lotto.enums.Grade;

public final class History {

  private final Grade grade;
  private final int count;

  public History(Grade grade, int count) {
    this.grade = grade;
    this.count = count;
  }

  public Grade getGrade() {
    return grade;
  }

  public int getCount() {
    return count;
  }
}
