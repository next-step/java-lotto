package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class LottoNumbers {

  public static final int LOTTO_NUMBER_COUNT = 6;

  private final List<LottoNumber> lottoNumbers;

  public LottoNumbers() {
    lottoNumbers = new ArrayList<>();
    for (int i = 1; i <= LOTTO_NUMBER_COUNT; i++) {
      lottoNumbers.add(new LottoNumber(i));
    }
  }

  public LottoNumbers(String[] winningNumbers) {
    this.lottoNumbers = Arrays.stream(winningNumbers)
        .map(Integer::parseInt)
        .map(LottoNumber::new)
        .collect(Collectors.toList());
  }

  public int size() {
    return lottoNumbers.size();
  }
}
