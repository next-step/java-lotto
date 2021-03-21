package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Lotto {

  private final List<LottoNumber> lottoNumbers;
  private static final int IS_MATCHED = 1;
  private static final int IS_NOT_MATCHED = 0;
  private static final String INVALID_LOTTO_COUNT = "6개 번호로 이루어진 로또가 아닙니다.";

  public Lotto(List<LottoNumber> lottoNumbers) {
    this.lottoNumbers = lottoNumbers;
  }

  public static Lotto of(List<Integer> numbers) {
    validateCount(numbers);
    List<LottoNumber> lottoNumbers = new ArrayList<>();
    numbers.forEach(number -> lottoNumbers.add(new LottoNumber(number)));
    return new Lotto(lottoNumbers);
  }

  private static void validateCount(List<Integer> numbers) {
    if (numbers.size() != 6) {
      throw new IllegalArgumentException(INVALID_LOTTO_COUNT);
    }
  }

  public boolean contains(LottoNumber lottoNumber) {
    return lottoNumbers.contains(lottoNumber);
  }

  public int containsCount(Lotto lotto) {
    int count = 0;
    for (LottoNumber lottoNumber : lottoNumbers) {
      count += (lotto.contains(lottoNumber) ? IS_MATCHED : IS_NOT_MATCHED);
    }
    return count;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Lotto lotto = (Lotto) o;
    return Objects.equals(lottoNumbers, lotto.lottoNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumbers);
  }

  public List<LottoNumber> getLottoNumbers() {
    return lottoNumbers;
  }


}
