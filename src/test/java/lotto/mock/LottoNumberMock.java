package lotto.mock;

import lotto.domain.LottoNumber;

public class LottoNumberMock extends LottoNumber {

  final int number;

  public LottoNumberMock(int number) {
    super(number);
    this.number = number;
  }
}
