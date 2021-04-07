package step02.code.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum GradeEnum {
  FIRST(6, 2_000_000_000),
  SECOND(5, 30_000_000), // 5 + 보너스 숫자 일치
  THIRD(5, 1_500_000),
  FOURTH(4, 50_000),
  FIFTH(3, 5_000),
  NONE(0, 0);

  private static final int SECOND_OR_THIRD_NUMBER = 5;

  private final int matched;
  private final int prizeMoney;

  private GradeEnum(int matched, int prizeMoney) {
    this.matched = matched;
    this.prizeMoney = prizeMoney;
  }

  public static GradeEnum fromGrade(int matched, boolean isMatchBonus) {
    return Arrays.stream(GradeEnum.values())
      .filter(gradeEnum -> gradeEnum.matched == matched)
      .filter(gradeEnum -> isCorrectGrade(gradeEnum, isMatchBonus))
      .findAny()
      .orElse(GradeEnum.NONE);
  }

  public static boolean isCorrectGrade(GradeEnum gradeEnum, boolean isMatchBonus) {
    if(gradeEnum.matched != SECOND_OR_THIRD_NUMBER) {
      return true;
    }
    if(isMatchBonus) {
      return gradeEnum == GradeEnum.SECOND;
    }
    return gradeEnum == GradeEnum.THIRD;
  }

  public int prize() {
    return prizeMoney;
  }

  public int matched() {
    return matched;
  }

  public static List<GradeEnum> sorted() {
    return Arrays.stream(GradeEnum.values())
      .filter(gradeEnum -> !gradeEnum.equals(GradeEnum.NONE))
      .sorted(Comparator.comparing(GradeEnum::prize))
      .collect(Collectors.toList());
  }

}
