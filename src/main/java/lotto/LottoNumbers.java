package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public final class LottoNumbers {

  public static final int LOTTO_NUMBER_COUNT = 6;

  private final Set<LottoNumber> lottoNumbers;

  public LottoNumbers() {
    lottoNumbers = new HashSet<>();
    for (int i = 1; i <= LOTTO_NUMBER_COUNT; i++) {
      lottoNumbers.add(new LottoNumber(i));
    }
  }

  public LottoNumbers(String[] winningNumbers) {
    this.lottoNumbers = Arrays.stream(winningNumbers)
        .map(Integer::parseInt)
        .map(LottoNumber::new)
        .collect(Collectors.toSet());
  }

  public int size() {
    return lottoNumbers.size();
  }
}
