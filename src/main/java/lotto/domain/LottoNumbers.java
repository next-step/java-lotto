package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
  private List<Integer> lottoNumbers = new ArrayList<>();

  public List<Integer> createLottoNumbers(List<Integer> lottoNumbers){
    this.lottoNumbers = lottoNumbers;
    return lottoNumbers;
  }

  public int findCount(List<Integer> numbers) {
    return (int) lottoNumbers
        .stream()
        .filter(numbers::contains)
        .count();
  }

  public int findCount(Lotto lotto) {
    return lotto.findCount(lottoNumbers);
  }

  public List<Integer> getLottoNumbers() {
    return lottoNumbers;
  }

  public boolean containBonusBall(int bonusNumber) {
    return lottoNumbers.contains(bonusNumber);
  }
}
