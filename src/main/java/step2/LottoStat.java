package step2;

import java.util.Objects;

public class LottoStat {

  private final LottoRank rank;
  private int winningCount;

  public LottoStat(LottoRank rank) {
    this(rank, 0);
  }

  public LottoStat(LottoRank rank, int winningCount) {
    this.rank = rank;
    this.winningCount = winningCount;
  }

  public int total() {
    return rank.getAmount() * winningCount;
  }

  public void decide(int matchCount, boolean hasBonusNumber) {
    if (rank.isWin(matchCount, hasBonusNumber)) {
      winningCount++;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoStat lottoStat = (LottoStat) o;
    return winningCount == lottoStat.winningCount &&
        rank == lottoStat.rank;
  }

  @Override
  public int hashCode() {
    return Objects.hash(rank, winningCount);
  }

  @Override
  public String toString() {
    return String.format("%s- %d개", rank, winningCount);
  }

}
