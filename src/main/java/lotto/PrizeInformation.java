package lotto;

import java.util.Arrays;

public enum PrizeInformation {

  THREE(3, 5000),
  FOUR(4, 50000),
  FIVE(5, 1500000),
  SIX(6, 2000000000);

  private int boundaryCount;
  private int prize;

  PrizeInformation(int boundaryCount, int prize) {
    this.boundaryCount = boundaryCount;
    this.prize = prize;
  }

  public int getBoundaryCount() {
    return boundaryCount;
  }

  public int getPrize() {
    return prize;
  }

  public static void main(String[] args) {
    Arrays.stream(PrizeInformation.values()).forEach(a -> System.out.println(a.getPrize()));
  }

}
