package study.lotto.service;

import study.lotto.model.Lotto;
import study.lotto.model.LottoGeneral;

public class LottoServiceImpl implements LottoService{
  private  final LottoGeneral lottoGeneral;

  public LottoServiceImpl(LottoGeneral lottoGeneral) {
    this.lottoGeneral = lottoGeneral;
  }

  @Override
  public Lotto makePurchase(int amount) {
    int count = amount / 1000;
    return new Lotto(count, lottoGeneral);
  }
}
