package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

  private List<Integer> lottoNumbers = new ArrayList<>();

  public Lotto(List<Integer> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public int confirmWinning(List<Integer> winningNumbers) {
    int count = 0;
    for (int winningNumber :winningNumbers) {
      if(lottoNumbers.contains(winningNumber)) count++;
    }
    return count;
  }

  public List<Integer> getLottoNumbers() {
    return lottoNumbers;
  }


}
