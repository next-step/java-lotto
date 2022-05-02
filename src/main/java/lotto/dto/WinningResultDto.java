package lotto.dto;

import lotto.enums.Grade;

public class WinningResultDto {

  private final Grade grade;
  private final int count;


  public WinningResultDto(Grade grade, int count) {
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
