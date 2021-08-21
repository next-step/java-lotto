package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

  @ParameterizedTest(name = "로또번호 생성 테스트 : {0}")
  @ValueSource(ints = {1, 2, 45})
  void create(int number) {
    //when
    LottoNumber lottoNumber = new LottoNumber(number);

    //then
    assertThat(lottoNumber).isEqualTo(new LottoNumber(number));
  }

  @ParameterizedTest(name = "로또번호 생성 에러 테스트 : {0}")
  @ValueSource(ints = {-1, 0, 46})
  void invalidCreate(int number) {
    //then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      new LottoNumber(number);
    });
  }
}
