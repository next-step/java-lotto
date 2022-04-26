package lotto.model;

import java.util.List;
import java.util.Objects;
import lotto.enums.Release;

public class Statistics {

  private final Release release;
  private final Integer count;


  public Statistics(Release release) {
    this(release, 0);
  }

  public Statistics(Release release, Integer count) {
    this.release = release;
    this.count = count;
  }

  public Statistics awardCount(List<Product> allProduct, List<Integer> winnerList) {
    return new Statistics(release, release.coincideLotto(allProduct, winnerList));
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
    return release == that.release && Objects.equals(count, that.count);
  }

  @Override
  public int hashCode() {
    return Objects.hash(release, count);
  }

  @Override
  public String toString() {
    return release.getExpectNumber() +
        "개 일치 (" + release.getAwardPrice() + ")"
        + "- " + count + "개";
  }
}
