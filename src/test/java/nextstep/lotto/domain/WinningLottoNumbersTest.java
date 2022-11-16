package nextstep.lotto.domain;

import static nextstep.lotto.domain.LottoFactory.createLotto;
import static nextstep.lotto.domain.LottoNumber.lottoNumber;
import static nextstep.lotto.domain.LottoResult.FIFTH_PLACE;
import static nextstep.lotto.domain.LottoResult.FIRST_PLACE;
import static nextstep.lotto.domain.LottoResult.FOURTH_PLACE;
import static nextstep.lotto.domain.LottoResult.LOSE;
import static nextstep.lotto.domain.LottoResult.SECOND_PLACE;
import static nextstep.lotto.domain.LottoResult.THIRD_PLACE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.api.Assertions.assertAll;

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

  @DisplayName("로또 번호로 당첨 결과를 확인 할 수 있다.")
  @Test
  public void spec03() {
    final WinningLottoNumbers winningLottoNumbers = new WinningLottoNumbers(
      Set.of(
        lottoNumber(1),
        lottoNumber(2),
        lottoNumber(3),
        lottoNumber(4),
        lottoNumber(5),
        lottoNumber(6)),
      lottoNumber(7)
    );

    assertAll(
      () -> assertThat(winningLottoNumbers.match(createLotto(1, 2, 3, 4, 5, 6)))
        .isEqualTo(FIRST_PLACE),
      () -> assertThat(winningLottoNumbers.match(createLotto(1, 2, 3, 4, 5, 7)))
        .isEqualTo(SECOND_PLACE),
      () -> assertThat(winningLottoNumbers.match(createLotto(1, 2, 3, 4, 5, 8)))
        .isEqualTo(THIRD_PLACE),
      () -> assertThat(winningLottoNumbers.match(createLotto(1, 2, 3, 4, 9, 8)))
        .isEqualTo(FOURTH_PLACE),
      () -> assertThat(winningLottoNumbers.match(createLotto(4, 5, 6, 7, 8, 9)))
        .isEqualTo(FIFTH_PLACE),
      () -> assertThat(winningLottoNumbers.match(createLotto(10, 11, 12, 13, 14, 15)))
        .isEqualTo(LOSE),
      () -> assertThat(winningLottoNumbers.match(createLotto(7, 11, 12, 13, 14, 15)))
        .isEqualTo(LOSE)
    );
  }
}
