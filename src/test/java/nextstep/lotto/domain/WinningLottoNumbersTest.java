package nextstep.lotto.domain;

import static nextstep.lotto.domain.LottoNumber.lottoNumber;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoNumbersTest {

  @DisplayName("당첨 번호와 보너스 번호는 중복될 수 없다.")
  @Test
  public void spec01() {
    assertThatIllegalArgumentException().isThrownBy(
      () -> new WinningLottoNumbers(
        Set.of(
          lottoNumber(1),
          lottoNumber(2),
          lottoNumber(3),
          lottoNumber(4),
          lottoNumber(5),
          lottoNumber(6)),
        lottoNumber(2)
      ));
  }

  @DisplayName("서로 다른 6자리 번호와 보너스 번호로 당첨 번호를 생성할 수 있다.")
  @Test
  public void spec02() {
    assertThatNoException().isThrownBy(
      () -> new WinningLottoNumbers(
        Set.of(
          lottoNumber(1),
          lottoNumber(2),
          lottoNumber(3),
          lottoNumber(4),
          lottoNumber(5),
          lottoNumber(6)),
        lottoNumber(7)
      ));
  }
}
