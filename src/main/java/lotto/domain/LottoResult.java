package lotto.domain;

import java.util.Objects;

public class LottoResult {

  private final long matchedCount;

  public LottoResult(long matchedCount) {
    this.matchedCount = matchedCount;
  }

  LottoRank getLottoRank() {
    return LottoRank.findByMatchCount(matchedCount);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoResult that = (LottoResult) o;
    return matchedCount == that.matchedCount;
  }

  @Override
  public int hashCode() {
    return Objects.hash(matchedCount);
  }
}
