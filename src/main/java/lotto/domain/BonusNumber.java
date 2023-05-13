package lotto.domain;

import java.util.List;

public class BonusNumber {

  private LottoNumber number;

  public BonusNumber(LottoNumber number) {
    this.number = number;
  }

  public void validate(List<LottoNumber> numbers) {
      if (numbers.contains(number)) {
        throw new IllegalArgumentException("보너스 숫자는 이전 주 당첨 번호와 중복될 수 없습니다.");
      }
  }

  public LottoNumber lottoNumber() {
    return number;
  }
}
