package lotto.domain.generator;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.List;

public class ManualLottoGenerator implements LottoGenerator {

  private final List<LottoNumber> lottoNumberList;

  public ManualLottoGenerator(List<LottoNumber> lottoNumberList) {
    this.lottoNumberList = lottoNumberList;
  }

  @Override
  public Lotto generate() {
    return new Lotto(lottoNumberList);
  }
}
