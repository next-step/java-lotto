package lotto.domain;

public final class LottoRoi {

  private final double roi;

  public LottoRoi(double roi) {
    this.roi = roi;
  }

  public boolean lessThan(int i) {
    return roi < i;
  }

  public double getValue() {
    return roi;
  }
}
