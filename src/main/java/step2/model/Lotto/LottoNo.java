package step2.model.Lotto;

public class LottoNo {

  int LottoNum;

  public LottoNo(int lottoNum) {
    LottoNum = lottoNum;
  }

  public int getLottoNum() {
    return LottoNum;
  }

  @Override
  public boolean equals(Object lottoNo) {
    return this.LottoNum == ((LottoNo)lottoNo).getLottoNum();
  }
}
