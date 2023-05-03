package study.lottogame.domain;

import java.util.Collections;
import java.util.Set;

public class Lottery {

  public static final Money LOTTERY_PRICE = new Money(1000);
  public static final int LOTTO_NUMBER_COUNT = 6;

  private Set<LottoNumber> lottoNumbers;

  public Lottery(final Set<LottoNumber> lottoNumbers) {
    if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
      throw new IllegalArgumentException("유효하지 않은 입력입니다.");
    }

    this.lottoNumbers = lottoNumbers;
  }

  public int matchLottoNumber(Lottery otherLottery) {
    int countOfMatch = 0;
    Set<LottoNumber> otherLottoNumbers = otherLottery.getLottoNumbers();
    for (LottoNumber lottoNumber : lottoNumbers) {
      if (otherLottoNumbers.contains(lottoNumber)) {
        countOfMatch++;
      }
    }
    return countOfMatch;
  }

  public Set<LottoNumber> getLottoNumbers() {
    return Collections.unmodifiableSet(lottoNumbers);
  }
}
