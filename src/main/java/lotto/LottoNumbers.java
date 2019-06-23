package lotto;

import java.util.List;

public class LottoNumbers {

  List<LottoNumber> lottoNumbers;

  public LottoNumbers(List<LottoNumber> lottoNubers) {
    this.lottoNumbers = lottoNubers;
  }

  public Object getSize() {
    return lottoNumbers.size();
  }

  public List<LottoNumber> getValues() {
    return lottoNumbers;
  }

}
