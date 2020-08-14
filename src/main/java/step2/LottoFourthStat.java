package step2;

public class LottoFourthStat extends LottoStat {

  private int count;

  public LottoFourthStat(int count) {
    super("3개 일치", 5000);
    this.count = count;
  }

  @Override
  int getCount() {
    return count;
  }
}
