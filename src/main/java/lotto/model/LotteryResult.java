package lotto.model;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import lotto.enums.Grade;

public final class LotteryResult {

  private static final int START_COUNT = 0;
  private static final int INCREASE_VALUE = 1;

  private static final Map<Grade, Integer> gradeMap = new EnumMap<>(Grade.class);

  private LotteryResult() {
  }

  static {
    for (Grade value : Grade.values()) {
      gradeMap.put(value, START_COUNT);
    }
  }


  public static void increase(Grade grade) {
    int originValue = gradeMap.get(grade);
    gradeMap.replace(grade, originValue, originValue + INCREASE_VALUE);
  }

  public static Map<Grade, Integer> result() {
    return gradeMap;
  }
}
