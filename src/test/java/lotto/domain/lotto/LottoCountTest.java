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
    // given
    long lottoCount = 10;
    long manualCount = 4;

    // when
    // then
    assertThat(new LottoCount(lottoCount, manualCount)).isEqualTo(new LottoCount(lottoCount, manualCount));
  }

  @Test
  @DisplayName("음수로 생성 시도시 오류발생 테스트")
  void createNegative() {
    // given
    // when
    // then
    assertAll(
        () -> assertThatThrownBy(() -> new LottoCount(-10, 4))
            .isInstanceOf(NegativeLottoCountException.class)
            .hasMessage(NegativeLottoCountException.INVALID_LOTTO_COUNT),
        () -> assertThatThrownBy(() -> new LottoCount(10, -4))
            .isInstanceOf(NegativeLottoCountException.class)
            .hasMessage(NegativeLottoCountException.INVALID_LOTTO_COUNT)
    );
  }
}
