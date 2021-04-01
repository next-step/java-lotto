package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import lotto.exception.MoreManualLottoException;
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

  @Test
  @DisplayName("기본 로또 매수보다 많은 수동 로또 생성 시도시 오류발생 테스트")
  void createMoreManualCount() {
    // given
    // when
    // then
    assertThatThrownBy(() -> new LottoCount(1, 4))
        .isInstanceOf(MoreManualLottoException.class)
        .hasMessage(MoreManualLottoException.INVALID_MANUAL_LOTTO_COUNT);
  }
}
