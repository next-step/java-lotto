package lotto;

import static java.util.Collections.unmodifiableList;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class LottoNumbers {

  private static final int LOTTO_NUMBER_COUNT = 6;

  List<LottoNumber> lottoNumbers;

  public LottoNumbers(List<LottoNumber> lottoNumbers) {
    if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
      throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
    }
    this.lottoNumbers = lottoNumbers;
    Collections.sort(lottoNumbers);
  }

  public int getSize() {
    return lottoNumbers.size();
  }

  public List<LottoNumber> getValues() {
    return unmodifiableList(lottoNumbers);
  }

  public int countSameNumber(LottoNumbers numbers) {
    int twoLottoNumbersCount = this.getSize() + numbers.getSize();
    int deDuplicationCount = (int) Stream.of(this.getValues(), numbers.getValues())
        .flatMap(x -> x.stream())
        .distinct()
        .count();
    return twoLottoNumbersCount - deDuplicationCount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoNumbers that = (LottoNumbers) o;
    return Objects.equals(lottoNumbers, that.lottoNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lottoNumbers);
  }

  @Override
  public String toString() {
    return "LottoNumbers{" +
        "lottoNumbers=" + lottoNumbers +
        '}';
  }

}
