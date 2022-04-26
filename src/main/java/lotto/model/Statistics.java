package lotto.model;

import java.util.List;
import java.util.Objects;
import lotto.enums.Grade;

public class Statistics {

  private final Grade grade;
  private final Integer count;

  private final Integer reward;


  public Statistics(Grade grade) {
    this(grade, 0);
  }

  public Statistics(Grade grade, Integer count) {
    this(grade, count, 0);
  }

  public Statistics(Grade grade, Integer count, Integer reward) {
    this.grade = grade;
    this.count = count;
    this.reward = reward;
  }

  public Statistics awardCount(List<Product> allProduct, List<Integer> winnerList) {
    int count = grade.coincideLotto(allProduct, winnerList);
    return new Statistics(grade, count, this.reward + grade.winningAmount(count));
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Statistics that = (Statistics) o;
    return grade == that.grade && Objects.equals(count, that.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(grade, count);
  }

  @Override
  public String toString() {
    return grade.getExpectNumber() +
        "개 일치 (" + grade.getAwardPrice() + ")"
        + "- " + count + "개";
  }
}
