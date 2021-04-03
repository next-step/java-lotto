package lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.MoreManualLottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoCountsTest {

  @Test
  @DisplayName("생성 테스트")
  void create() {
    // given
    long lottoCount = 10;
    long manualCount = 4;

    // when
    // then
    assertThat(new LottoCounts(new LottoCount(lottoCount), new LottoCount(manualCount)))
        .isEqualTo(new LottoCounts(new LottoCount(lottoCount), new LottoCount(manualCount)));
  }

  @Test
  @DisplayName("기본 로또 매수보다 많은 수동 로또 생성 시도시 오류발생 테스트")
  void createMoreManualCount() {
    // given
    // when
    // then
    assertThatThrownBy(() -> new LottoCounts(new LottoCount(1), new LottoCount(4)))
        .isInstanceOf(MoreManualLottoException.class)
        .hasMessage(MoreManualLottoException.INVALID_MANUAL_LOTTO_COUNT);
  }

  @Test
  @DisplayName("수동을 제외한 로또 번호를 자동으로 생성해준다.")
  void automaticLotto() {
    // given
    long lottoCount = 10;
    long manualCount = 4;
    long automaticCount = lottoCount - manualCount;

    LottoCounts lottoCounts = new LottoCounts(new LottoCount(lottoCount), new LottoCount(manualCount));

    // when
    List<Lotto> automaticLottos = lottoCounts.automaticLottos();

    // then
    assertThat(automaticLottos).hasSize((int) automaticCount);
  }
}
