package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Lotto {

  public static final Money PRICE = new Money(1000);
  public static final int NUMBER_SIZE = 6;
  private final Set<LottoNumber> lottoNumbers;

  private Lotto(List<LottoNumber> lottoNumbers) {
    checkLottoNumbers(lottoNumbers);
    this.lottoNumbers = new TreeSet<>(lottoNumbers);
  }

  public static Lotto issueByManual(List<Integer> numbers) {
    List<LottoNumber> lottoNumbers = numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
    return new Lotto(lottoNumbers);
  }

  public int matchedNumberCnt(Lotto winningLotto) {
    return (int) lottoNumbers.stream().filter(winningLotto.lottoNumbers::contains).count();
  }

  public List<Integer> numbers() {
    return lottoNumbers.stream().map(LottoNumber::number).collect(Collectors.toList());
  }

  private void checkLottoNumbers(List<LottoNumber> lottoNumbers) {
    if (lottoNumbers.size() != NUMBER_SIZE) {
      throw new IllegalArgumentException("Lotto를 생성할때는 " + NUMBER_SIZE + "개의 숫자가 필요합니다.");
    }
    if (lottoNumbers.stream().distinct().count() != lottoNumbers.size()) {
      throw new IllegalArgumentException("중복된 숫자는 허용하지 않습니다.");
    }
  }
}
