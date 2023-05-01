package study.lottogame.domain;

import java.util.HashSet;
import java.util.List;

public class Lottery {

  public static final int LOTTO_NUMBER_COUNT = 6;

  private List<LottoNumber> lottoNumbers;

  public Lottery(List<LottoNumber> lottoNumbers) {
    validateLottoNumbers(lottoNumbers);

    this.lottoNumbers = lottoNumbers;
  }

  private void validateLottoNumbers(List<LottoNumber> lottoNumbers) {
    if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
      throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }

    if (new HashSet<>(lottoNumbers).size() != LOTTO_NUMBER_COUNT) {
      throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }
  }

  public int matchLottoNumber(Lottery otherLottery) {
    int countOfMatch = 0;
    List<LottoNumber> otherLottoNumbers = otherLottery.getLottoNumbers();
    for (LottoNumber lottoNumber : lottoNumbers) {
      if (otherLottoNumbers.contains(lottoNumber)) {
        countOfMatch++;
      }
    }
    return countOfMatch;
  }

  public List<LottoNumber> getLottoNumbers() {
    return lottoNumbers;
  }
}
