package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

  @ParameterizedTest(name = "생성(new) 테스트 : {0}")
  @ValueSource(ints = {1, 2, 45})
  void createTest(int number) {
    //when
    LottoNumber lottoNumber = new LottoNumber(number);

    //then
    assertThat(lottoNumber).isEqualTo(new LottoNumber(number));
  }

  @ParameterizedTest(name = "잘못된 생성(new) 테스트 : {0}")
  @ValueSource(ints = {-1, 0, 46})
  void invalidCreateTest(int number) {
    //then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new LottoNumber(number);
    });
  }

  @ParameterizedTest(name = "생성 및 반환(valueOf) 테스트 : {0}")
  @ValueSource(ints = {1, 2, 45})
  void valueOfTest(int number) {
    //when
    LottoNumber lottoNumber = LottoNumber.valueOf(number);

    //then
    assertThat(lottoNumber == LottoNumber.valueOf(number)).isTrue();
    assertThat(lottoNumber).isEqualTo(new LottoNumber(number));
  }

  @ParameterizedTest(name = "잘못된 생성 및 반환(valueOf)테스트 : {0}")
  @ValueSource(ints = {-1, 0, 46})
  void invalidValueOfTest(int number) {
    //then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      LottoNumber.valueOf(number);
    });
  }
}
