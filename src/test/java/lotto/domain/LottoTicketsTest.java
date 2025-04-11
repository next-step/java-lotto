package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

  @Test
  void 수동_자동_로또_생성() {
    List<Lotto> manualLottos = Arrays.asList(
        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
        new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
    );

    assertThat(LottoTickets.of(manualLottos, 5).size()).isEqualTo(5);
  }

  @Test
  void 수동_로또_수_초과_예외() {
    List<Lotto> manualLottos = Arrays.asList(
        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
        new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
    );
    assertThatThrownBy(() -> LottoTickets.of(manualLottos, 1))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("수동 로또 수가 구매 가능한 로또 수를 초과했습니다.");
  }

  @Test
  void 수동_로또_목록이_null이면_예외_발생() {
    assertThatThrownBy(() -> LottoTickets.of(null, 1))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("수동 로또 목록이 null입니다.");
  }

  @Test
  void 당첨_통계_생성() {
    LottoStatistics statistics = LottoTickets.of(1)
        .createWinningStatistics(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7);
    assertThat(statistics).isNotNull();
  }

  @Test
  void 당첨_번호_null_예외() {
    assertThatThrownBy(() -> LottoTickets.of(5).createWinningStatistics(null, 7))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("당첨 번호가 null입니다.");
  }
} 