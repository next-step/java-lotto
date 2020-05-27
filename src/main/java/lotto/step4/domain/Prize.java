package lotto.step4.domain;

public class Prize {
  private final Rank rank;
  private final long count;

  private Prize (Rank rank, long count) {
    this.rank = rank;
    this.count = count;
  }

  public static Prize of (Rank rank, long count) {
    return new Prize(rank, count);
  }

  public long getTotalPrize () {
    return rank.getPrice() * count;
  }

  public Rank getRank () {
    return rank;
  }

  public long getCount () {
    return count;
  }
}
