package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

  public static final int NUMBER_SIZE = 6;
  private final List<LottoNumber> lottoNumbers;

  public Lotto(List<Integer> numbers) {
    checkNumbers(numbers);
    this.lottoNumbers = numbers.stream().map(LottoNumber::new).collect(Collectors.toList());
  }

  public List<Integer> getLottoNumbers() {
    return lottoNumbers.stream().map(LottoNumber::getNumber).collect(Collectors.toList());
  }

  private void checkNumbers(List<Integer> numbers) {
    if (numbers == null || numbers.size() != NUMBER_SIZE) {
      throw new IllegalArgumentException("Lotto를 생성할때는 " + NUMBER_SIZE + "개의 숫자가 필요합니다.");
    }
    if (numbers.stream().distinct().count() != numbers.size()) {
      throw new IllegalArgumentException("중복된 숫자는 허용하지 않습니다.");
    }
  }
}
