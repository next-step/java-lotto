package domain.prizeBoard;
import java.util.function.Supplier;

public enum PrizeBoard {
  MATCH3(3, () -> 5000),
  MATCH4(4, () -> 50000),
  MATCH5(5, () -> 1500000),
  MATCH6(6, () -> 2000000000);

  private final int matchNum;
  private final Supplier<Integer> lottoPrizeMatching;

  public Integer matchPrize() {
    return this.lottoPrizeMatching.get();
  }

  PrizeBoard(int matchNum, Supplier<Integer> lottoPrizeMatching) {
    this.matchNum = matchNum;
    this.lottoPrizeMatching = lottoPrizeMatching;
  }
}
