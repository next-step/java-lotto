package lotto.domain;

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

  public int compare(LottoNumbers other) {
    int count = 0;

    for (LottoNumber lottoNumber : other.lottoNumbers) {
      count = countMatch(count, lottoNumber);
    }

    return count;
  }

  private int countMatch(int count, LottoNumber lottoNumber) {
    if (lottoNumbers.contains(lottoNumber)) {
      count++;
    }
    return count;
  }

  public void print() {
    System.out.println(lottoNumbers.stream()
        .map(LottoNumber::toStringValue)
        .collect(Collectors.joining(", ", "[", "]")));
  }
}
