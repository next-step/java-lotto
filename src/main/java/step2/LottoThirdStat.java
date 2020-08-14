package step2;

public class LottoThirdStat extends LottoStat {

  private int count;

  public LottoThirdStat(int count) {
    super("4개 일치", 50000);
    this.count = count;
  }

  @Override
  int getCount() {
    return count;
  }
}
