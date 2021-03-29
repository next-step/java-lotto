package step02.code.domain;

import java.util.Arrays;

public enum GradeEnum {
  FIRST(6, 2000000000),
  SECOND(5, 30000000), // 5 + 보너스 숫자 일치
  THIRD(5, 1500000),
  FOURTH(4, 50000),
  FIFTH(3, 5000),
  NONE(0, 0);

  private final int grade;
  private final int prizeMoney;

  private GradeEnum(int grade, int prizeMoney) {
    this.grade = grade;
    this.prizeMoney = prizeMoney;
  }

  public static GradeEnum fromGrade(int grade, boolean isMatchBonus) {
    return Arrays.stream(GradeEnum.values())
      .filter(gradeEnum -> gradeEnum.grade == grade)
      .filter(gradeEnum -> isSecond(grade, gradeEnum, isMatchBonus))
      .findAny()
      .orElse(GradeEnum.NONE);
  }

  public static boolean isSecond(int grade, GradeEnum gradeEnum, boolean isMatchBonus) {
    if(grade != 5) {
      return true;
    }
    if(isMatchBonus) {
      return gradeEnum == gradeEnum.SECOND;
    }
    return gradeEnum == gradeEnum.THIRD;
  }

  public int prize() {
    return prizeMoney;
  }

}
