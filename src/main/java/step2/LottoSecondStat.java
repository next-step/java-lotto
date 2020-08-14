package step2;

public class LottoSecondStat extends LottoStat {

  private int count;

  public LottoSecondStat(int count) {
    super("5개 일치", 1500000);
    this.count = count;
  }

  @Override
  int getCount() {
    return count;
  }
}
