package nextstep.lotto.domain;

public class LottoWinCount {

  private final LottoResult grade;
  private final long count;

  public LottoWinCount(LottoResult grade, long count) {
    this.grade = grade;
    this.count = count;
  }

  public LottoResult result() {
    return grade;
  }

  public long count() {
    return count;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    LottoWinCount that = (LottoWinCount) o;

    if (count != that.count) {
      return false;
    }
    return grade == that.grade;
  }

  @Override
  public int hashCode() {
    int result = grade != null ? grade.hashCode() : 0;
    result = 31 * result + (int) (count ^ (count >>> 32));
    return result;
  }

  @Override
  public String toString() {
    return "LottoWinCount{" +
      "grade=" + grade +
      ", count=" + count +
      '}';
  }
}
