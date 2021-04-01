package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lotto.exception.IllegalLottoNumberSizeException;

public final class LottoNumbers {

  public static final int LOTTO_NUMBER_COUNT = 6;

  private final Set<LottoNumber> lottoNumbers;

  public LottoNumbers(LottoNumberCreationStrategy lottoNumberCreationStrategy) {
    this(lottoNumberCreationStrategy.create());
  }

  public LottoNumbers(String[] winningNumbers) {
    this(Arrays.stream(winningNumbers)
        .map(LottoNumber::valueOf)
        .collect(Collectors.toList()));
  }

  public LottoNumbers(List<LottoNumber> lottoNumbers) {
    Set<LottoNumber> lottoNumberSet = new HashSet<>(lottoNumbers);
    validateLottoNumbersSize(lottoNumberSet);
    this.lottoNumbers = lottoNumberSet;
  }

  private void validateLottoNumbersSize(Set<LottoNumber> lottoNumbers) {
    if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
      throw new IllegalLottoNumberSizeException();
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

  public List<LottoNumber> getSortedLottoNumbers() {
    List<LottoNumber> lottoNumberList = new ArrayList<>(lottoNumbers);
    Collections.sort(lottoNumberList);
    return Collections.unmodifiableList(lottoNumberList);
  }

  public boolean contains(LottoNumber lottoNumber) {
    return lottoNumbers.contains(lottoNumber);
  }
}
