package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoNumberTest {

  @DisplayName("로또 번호 생성 입력값 검증")
  @ParameterizedTest
  @ValueSource(ints = {1, 45})
  void create(Integer number) {
    assertThat(new LottoNumber(number).getNumber()).isEqualTo(number);
  }

  @DisplayName("범위 밖의 숫자로 로또번호 생성 시 예외를 던진다")
  @ParameterizedTest
  @ValueSource(ints = {0, 46})
  void outOfRange(Integer number) {
    assertThatIllegalArgumentException().isThrownBy(() -> new LottoNumber(number))
        .withMessageMatching("\\d+ 로또번호 범위가 올바르지 않습니다.");
  }
}
