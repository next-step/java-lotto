package lotto.domain.model;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;

public class Lotteries {

  private List<Lotto> lottoNumbers;

  public Lotteries(List<String[]> lottoNumbers) {
    this.lottoNumbers = resolveLottoNumbers(lottoNumbers);
  }

  private List<Lotto> resolveLottoNumbers(List<String[]> lottoNumbers) {
    return lottoNumbers.stream()
        .map(Lotto::new)
        .collect(Collectors.toList());
  }

  public int size() {
    return lottoNumbers.size();
  }

  public List<Lotto> getLottoNumbers() {
    return lottoNumbers;
  }
}
