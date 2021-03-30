package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.LottoNumberCreationStrategy;

public final class LottoNumbers {

  public static final int LOTTO_NUMBER_COUNT = 6;
  public static final String LOTTO_NUMBER_CREATION_FAILURE = "로또는 " + LOTTO_NUMBER_COUNT + "개의 번호로 이루어져야 합니다.";

  private final List<LottoNumber> lottoNumbers;

  public LottoNumbers(LottoNumberCreationStrategy lottoNumberCreationStrategy) {
    this(lottoNumberCreationStrategy.create());
  }

  public LottoNumbers(String[] winningNumbers) {
    this(Arrays.stream(winningNumbers)
        .map(LottoNumber::valueOf)
        .collect(Collectors.toList()));
  }

  public LottoNumbers(List<LottoNumber> lottoNumbers) {
    validateLottoNumbersSize(lottoNumbers);
    this.lottoNumbers = lottoNumbers;
  }

  private void validateLottoNumbersSize(List<LottoNumber> lottoNumbers) {
    if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
      throw new IllegalArgumentException(LOTTO_NUMBER_CREATION_FAILURE);
    }
  }

  public int size() {
    return lottoNumbers.size();
  }

  public int countMatchNumbers(LottoNumbers other) {
    int matchCount = 0;

    for (LottoNumber lottoNumber : other.lottoNumbers) {
      matchCount += countMatchNumber(lottoNumber);
    }

    return matchCount;
  }

  private int countMatchNumber(LottoNumber lottoNumber) {
    int count = 0;
    if (lottoNumbers.contains(lottoNumber)) {
      count++;
    }
    return count;
  }

  public List<LottoNumber> getLottoNumbers() {
    return Collections.unmodifiableList(lottoNumbers);
  }

  public boolean contains(LottoNumber lottoNumber) {
    return lottoNumbers.contains(lottoNumber);
  }
}
