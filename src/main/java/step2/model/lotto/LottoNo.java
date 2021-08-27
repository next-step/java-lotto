package step2.model.lotto;

public class LottoNo implements Comparable<LottoNo> {

  private int LottoNum;

  public LottoNo(int lottoNum) {
    LottoNum = lottoNum;
  }

  public int getLottoNum() {
    return LottoNum;
  }

  @Override
  public boolean equals(Object lottoNo) {
    return this.LottoNum == ((LottoNo) lottoNo).getLottoNum();
  }

  @Override
  public int compareTo(LottoNo lottoNo) {
    return this.getLottoNum() - lottoNo.getLottoNum();
  }
}
