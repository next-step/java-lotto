package study.step2.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningLottoTest {

  @DisplayName("지난 주 당첨 번호 생성 테스트")
  @Test
  void createWinningLotto() {
    //given
    WinningLotto winingLotto = new WinningLotto("1, 2, 3, 12, 15, 44");

    //when
    int winningLottoSize = winingLotto.getLottoNumbers().size();

    //then
    assertThat(winningLottoSize).isEqualTo(6);
  }

  @DisplayName("당첨 번호 중복 번호 테스트")
  @Test
  void checkDuplication() {
    //given
    String inputNumber = "1, 2, 3, 12, 15, 44";

    //when
    Throwable thrown =  catchThrowable(() -> new Lotto(inputNumber));

    //then
    assertThat(thrown).isEqualTo(null);
  }

  @DisplayName("당첨 번호 중복 테스트")
  @Test
  void checkDuplicationFail() {
    //given
    String inputNumber = "1, 2, 3, 12, 15, 15";

    //when
    Throwable thrown =  catchThrowable(() -> new Lotto(inputNumber));

    //then
    assertThat(thrown).isInstanceOf(RuntimeException.class);
  }

  @DisplayName("지난 주 당첨 번호 음수 테스트")
  @Test
  void validatorPositiveNumbers() {
    //given
    //when
    Throwable thrown =  catchThrowable(() -> new WinningLotto("1, 2, 3, 12, 15, -44"));

    //then
    assertThat(thrown).isInstanceOf(RuntimeException.class);
  }

  @DisplayName("지난 주 당첨 번호 음수 실패 테스트")
  @Test
  void validatorPositiveNumbersFail() {
    //given
    //when
    Throwable thrown =  catchThrowable(() -> new WinningLotto("1, 2, 3, 12, 15, 44"));

    //then
    assertThat(thrown).isEqualTo(null);
  }

  @DisplayName("지난주 당첨 번호에 보너스 번호가 포함하는지 테스트")
  @Test
  void bonusValidation() {
    //given
    WinningLotto winingLotto = new WinningLotto("1, 2, 3, 12, 15, 16");
    LottoNumber bonusNumber = LottoNumber.valueOf(6);

    //when
    Throwable thrown =  catchThrowable(() -> winingLotto.bonusValidation(bonusNumber));

    //then
    assertThat(thrown).isEqualTo(null);
  }

  @DisplayName("지난주 당첨 번호에 보너스 번호가 포함하는지 테스트")
  @Test
  void bonusValidationFail() {
    //given
    WinningLotto winingLotto = new WinningLotto("1, 2, 3, 12, 15, 16");
    LottoNumber bonusNumber = LottoNumber.valueOf(3);

    //when
    Throwable thrown =  catchThrowable(() -> winingLotto.bonusValidation(bonusNumber));

    //then
    assertThat(thrown).isInstanceOf(RuntimeException.class);
  }

}