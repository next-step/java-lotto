package study.step2.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

  @DisplayName("LottoNumber 생성 테스트")
  @Test
  void createLottoNumber() {
    // given
    String inputText = "1";

    // when
    LottoNumber lottoNumber = LottoNumber.valueOf(inputText);

    // then
    assertThat(lottoNumber).isEqualTo(LottoNumber.valueOf(inputText));
  }

  @DisplayName("LottoNumber 생성 실패 테스트")
  @Test
  void createLottoNumberFail() {
    // given
    String inputText = "46";

    //when
    Throwable thrown =  catchThrowable(() -> LottoNumber.valueOf(inputText));

    //then
    assertThat(thrown).isInstanceOf(RuntimeException.class);
  }

  @DisplayName("LottoNumber 음수일 때 생성 실패 테스트")
  @Test
  void validatePositiveNumber() {
    // given
    String inputText = "-10";

    //when
    Throwable thrown =  catchThrowable(() -> LottoNumber.valueOf(inputText));

    //then
    assertThat(thrown).isInstanceOf(RuntimeException.class);
  }

}
