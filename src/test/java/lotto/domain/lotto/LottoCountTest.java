package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import lotto.exception.NegativeLottoCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCountTest {

  @Test
  @DisplayName("생성 테스트")
  void create() {
    assertThat(new LottoCount(10)).isEqualTo(new LottoCount(10));
  }


  @Test
  @DisplayName("음수로 생성 시도시 오류발생 테스트")
  void createNegative() {
    assertThatThrownBy(() -> new LottoCount(-10))
        .isInstanceOf(NegativeLottoCountException.class)
        .hasMessage(NegativeLottoCountException.INVALID_LOTTO_COUNT);
  }

  @Test
  @DisplayName("큰 지 비교 테스트")
  void isBiggerThan() {
    // given
    LottoCount biggerCount = new LottoCount(10);
    LottoCount smallerCount = new LottoCount(4);

    // when
    // then
    assertAll(
        () -> assertThat(biggerCount.isBiggerThan(smallerCount)).isTrue(),
        () -> assertThat(smallerCount.isBiggerThan(biggerCount)).isFalse()
    );
  }

  @Test
  @DisplayName("뺄셈 테스트")
  void subtract() {
    // given
    long ten = 10;
    long four = 4;

    // when
    // then
    assertThat(new LottoCount(ten).subtract(new LottoCount(four))).isEqualTo(new LottoCount(ten - four));
  }

  @Test
  @DisplayName("int 타입 변환 테스트")
  void toInt() {
    assertThat(new LottoCount(10).toInteger()).isEqualTo(10);
  }
}
