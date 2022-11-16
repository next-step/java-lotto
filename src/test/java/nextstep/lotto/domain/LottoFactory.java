package nextstep.lotto.domain;

import static nextstep.lotto.domain.LottoNumber.lottoNumber;

import java.util.Set;

public class LottoFactory {

  public static Lotto createLotto(int number1, int number2, int number3, int number4, int number5,
    int number6) {
    return new Lotto(
      Set.of(
        lottoNumber(number1),
        lottoNumber(number2),
        lottoNumber(number3),
        lottoNumber(number4),
        lottoNumber(number5),
        lottoNumber(number6)
      )
    );
  }
}
