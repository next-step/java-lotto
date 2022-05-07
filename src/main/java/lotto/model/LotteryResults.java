package lotto.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.enums.Grade;

public final class LotteryResults {

  private static final int START_COUNT = 0;
  private static final int INCREASE_VALUE = 1;

  private static final Map<Grade, Integer> gradeMap = new EnumMap<>(Grade.class);

  private LotteryResults() {
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

  public List<LotteryResult> getLotteryResult() {
    Set<Entry<Grade, Integer>> entrySet = gradeMap
        .entrySet()
        .stream()
        .filter(g -> g.getKey() != Grade.NONE)
        .collect(Collectors.toSet());
    List<LotteryResult> lotteryResults = new ArrayList<>();
    for (Entry<Grade, Integer> gradeIntegerEntry : entrySet) {
      lotteryResults.add(
          new LotteryResult(gradeIntegerEntry.getKey(), gradeIntegerEntry.getValue()));
    }

    return lotteryResults;
  }

  public static Map<Grade, Integer> result() {
    return gradeMap;
  }
}
