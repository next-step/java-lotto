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
    validate(lottoNumbers);
    this.lottoNumbers = lottoNumbers;
    Collections.sort(lottoNumbers);
  }

  private void validate(List<LottoNumber> lottoNumbers) {
    lottoNumberCountCheck(lottoNumbers);
    repeatedNumberCheck(lottoNumbers);
  }

  private void lottoNumberCountCheck(List<LottoNumber> lottoNumbers) {
    if (lottoNumbers.size() != LOTTO_NUMBER_COUNT) {
      throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
    }
  }

  private void repeatedNumberCheck(List<LottoNumber> lottoNumbers) {
    long distinctCount = lottoNumbers.stream().map(LottoNumber::getValue).distinct().count();
    if (lottoNumbers.size() > distinctCount) {
      throw new IllegalArgumentException("로또 번호는 중복되면 안됩니다.");
    }
  }

  public int countSameNumber(LottoNumbers numbers) {
    int twoLottoNumbersCount = this.getSize() + numbers.getSize();
    int deDuplicationCount = (int) Stream.of(this.getValues(), numbers.getValues())
        .flatMap(x -> x.stream())
        .distinct()
        .count();
    return twoLottoNumbersCount - deDuplicationCount;
  }

  public boolean hasBonusNumber(int bonusNumber) {
    return lottoNumbers.stream()
        .map(LottoNumber::getValue)
        .filter(a -> a == bonusNumber)
        .findAny()
        .isPresent();
  }

  public int getSize() {
    return lottoNumbers.size();
  }

  public List<LottoNumber> getValues() {
    return unmodifiableList(lottoNumbers);
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
