package study.step2.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

import java.util.Set;
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

  @DisplayName("LottoNumber Set 생성 테스트")
  @Test
  void createLottoNumberSet() {
    // given
    Set<LottoNumber> lottoNumbers = LottoNumber.pick();

    // when
    int lottoNumbersSize = lottoNumbers.size();

    // then
    assertThat(lottoNumbersSize).isEqualTo(6);
  }

  @DisplayName("LottoNumber Set 생성 숫자가 0 보다 작은지 테스트")
  @Test
  void lottoNumberSetRangeTest() {
    // given
    Set<LottoNumber> lottoNumbers = LottoNumber.pick();

    // when
    boolean isInvalidRange = lottoNumbers.stream().anyMatch(lottoNumber -> lottoNumber.getLottoNumber() < 0);

    // then
    assertThat(isInvalidRange).isFalse();
  }

}
