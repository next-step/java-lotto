package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

  @ParameterizedTest(name = "로또 번호 입력 테스트")
  @ValueSource(ints = {1, 45})
  public void create_로또번호(int input) {
    LottoNumber lottoNumber = new LottoNumber(input);

    assertThat(lottoNumber.number()).isEqualTo(input);
  }

  @ParameterizedTest(name = "로또 번호가 아닌 숫자가 입력된 경우 IllegalArgument throw")
  @ValueSource(ints = {0, 46})
  public void create_로또번호_아닌_숫자(int input) {
    assertThatThrownBy(() -> new LottoNumber(input))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("올바른 로또 번호를 입력해주세요. 입력된 번호 : " + input);
  }
}
