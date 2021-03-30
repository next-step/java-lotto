package step02.code.domain;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public enum GradeEnum {
  FIRST(6, 2000000000),
  SECOND(5, 30000000), // 5 + 보너스 숫자 일치
  THIRD(5, 1500000),
  FOURTH(4, 50000),
  FIFTH(3, 5000),
  NONE(0, 0);

  private final int matched;
  private final int prizeMoney;

  private GradeEnum(int matched, int prizeMoney) {
    this.matched = matched;
    this.prizeMoney = prizeMoney;
  }

  public static GradeEnum fromGrade(int matched, boolean isMatchBonus) {
    return Arrays.stream(GradeEnum.values())
      .filter(gradeEnum -> gradeEnum.matched == matched)
      .filter(gradeEnum -> isSecond(matched, gradeEnum, isMatchBonus))
      .findAny()
      .orElse(GradeEnum.NONE);
  }

  public static boolean isSecond(int matched, GradeEnum gradeEnum, boolean isMatchBonus) {
    if(matched != 5) {
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

  public static List<GradeEnum> sorted() {
    return Arrays.stream(GradeEnum.values())
      .sorted(Comparator.comparing(GradeEnum::prize))
      .collect(Collectors.toList());
  }

}
