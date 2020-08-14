package step2;

public class LottoFirstStat extends LottoStat {

  private int count;

  public LottoFirstStat(int count) {
    super("6개 일치", 2000000000);
    this.count = count;
  }

  @Override
  int getCount() {
    return count;
  }
}
