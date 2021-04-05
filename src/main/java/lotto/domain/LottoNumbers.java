package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {
  private static final int LOTTO_NUMBER_GREATER_THAN_OR_EQUALS = 1;
  private static final int LOTTO_NUMBER_LESS_THAN = 46;

  private final List<LottoNumber> lottoNumbers;

  private LottoNumbers(List<LottoNumber> lottoNumbers) {
    this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
  }

  public static LottoNumbers generateSixNumbers() {
    List<LottoNumber> sixLottoNumbers = IntStream.range(LOTTO_NUMBER_GREATER_THAN_OR_EQUALS, LOTTO_NUMBER_LESS_THAN)
            .mapToObj(LottoNumber::generate)
            .collect(Collectors.toList());

    Collections.shuffle(sixLottoNumbers);
    return new LottoNumbers(sixLottoNumbers.subList(0, 6));
  }

  public int size() {
    return lottoNumbers.size();
  }

  public List<LottoNumber> getLottoNumbers() {
    return lottoNumbers;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LottoNumbers that = (LottoNumbers) o;
    return Objects.equals(lottoNumbers, that.lottoNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumbers);
  }

  @Override
  public String toString() {
    return String.valueOf(lottoNumbers);
  }
}
