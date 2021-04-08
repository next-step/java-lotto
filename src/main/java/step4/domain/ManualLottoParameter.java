package step4.domain;

import step4.domain.number.LottoNumber;
import step4.util.Splitter;

import java.util.List;

// TODO LottoNumbers로 이관 후 삭제(리팩토링)
public class ManualLottoParameter {
  private final String lottoParameter;

  public ManualLottoParameter(String lottoParameter) {
    this.lottoParameter = lottoParameter;
  }

  public List<LottoNumber> changeToListOfLottoNumber() {
    return Splitter.split(lottoParameter);
  }
}
