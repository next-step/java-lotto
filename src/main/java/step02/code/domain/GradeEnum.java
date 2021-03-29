package step02.code.domain;

import java.util.Arrays;

public enum GradeEnum {
  FIRST(6, 2000000000),
  SECOND(5, 1500000),
  THIRD(4, 50000),
  FOURTH(3, 5000),
  NONE(0, 0);

  private final int grade;
  private final int prizeMoney;

  private GradeEnum(int grade, int prizeMoney) {
    this.grade = grade;
    this.prizeMoney = prizeMoney;
  }

  public static GradeEnum fromGrade(int grade) {
    return Arrays.stream(GradeEnum.values())
      .filter(gradeEnum -> gradeEnum.grade == grade)
      .findAny()
      .orElse(GradeEnum.NONE);
  }

  public int prize() {
    return prizeMoney;
  }

}
