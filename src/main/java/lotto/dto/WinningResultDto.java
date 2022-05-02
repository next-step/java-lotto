package lotto.dto;

import lotto.enums.Grade;

public class WinningResultDto {

  private final Grade grade;


  public WinningResultDto(Grade grade) {
    this.grade = grade;
  }

  public Grade getGrade() {
    return grade;
  }

}
