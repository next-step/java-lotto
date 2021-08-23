package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

  public static final int NUMBER_SIZE = 6;
  private final List<LottoNumber> lottoNumbers;

  public Lotto(int[] numbers) {
    this(Arrays.stream(numbers).mapToObj(LottoNumber::new).collect(Collectors.toList()));
  }

  public Lotto(List<LottoNumber> lottoNumbers) {
    checkLottoNumbers(lottoNumbers);
    this.lottoNumbers = lottoNumbers;
  }

  public int getMatchingNumberCnt(Lotto winningLotto) {
    return (int) lottoNumbers.stream().filter(winningLotto.lottoNumbers::contains).count();
  }

  public List<Integer> getLottoNumbers() {
    return lottoNumbers.stream().map(LottoNumber::getNumber).collect(Collectors.toList());
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
