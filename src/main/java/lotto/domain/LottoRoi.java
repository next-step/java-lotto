package lotto.domain;

public final class LottoRoi {

  private final double roi;

  public LottoRoi(double roi) {
    this.roi = roi;
  }

  public void print() {
    System.out.print("총 수익률은 " + roi + "입니다.");

    if (roi < 1) {
      System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
      return;
    }

    System.out.println("(기준이 1이기 때문에 결과적으로 이익이라는 의미임)");
  }
}
