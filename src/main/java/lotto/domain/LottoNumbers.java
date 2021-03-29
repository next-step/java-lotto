package lotto.domain;

import static lotto.domain.Rank.FIVE_BONUS;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.LottoNumberCreationStrategy;

public final class LottoNumbers {

  public static final int LOTTO_NUMBER_COUNT = 6;

  private final List<LottoNumber> lottoNumbers;

  public LottoNumbers(LottoNumberCreationStrategy lottoNumberCreationStrategy) {
    lottoNumbers = lottoNumberCreationStrategy.create();
  }

  public LottoNumbers(String[] winningNumbers) {
    this.lottoNumbers = Arrays.stream(winningNumbers)
        .map(LottoNumber::valueOf)
        .collect(Collectors.toList());
  }

  public int size() {
    return lottoNumbers.size();
  }

  public Match compare(LottoNumbers other, LottoNumber bonusNumber) {
    int matchCount = 0;
    boolean bonusMatch = false;

    for (LottoNumber lottoNumber : other.lottoNumbers) {
      matchCount = countMatch(matchCount, lottoNumber);
    }

    if (matchCount == FIVE_BONUS.getMatchCount()) {
      bonusMatch = lottoNumbers.contains(bonusNumber);
    }

    return new Match(matchCount, bonusMatch);
  }

  private int countMatch(int count, LottoNumber lottoNumber) {
    if (lottoNumbers.contains(lottoNumber)) {
      count++;
    }
    return count;
  }

  public List<LottoNumber> getLottoNumbers() {
    return lottoNumbers;
  }
}
