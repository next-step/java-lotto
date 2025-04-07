package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

class LottoTicketsTest {

  @Test
  void 가격으로_로또_티켓_생성() {
    assertThat(LottoTickets.of(5000).size()).isEqualTo(5);
  }

  @Test
  void 금액_범위_예외() {
    assertThatThrownBy(() -> LottoTickets.of(999))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또 구매 금액은 1000원 이상이어야 합니다.");
  }

  @Test
  void 금액_단위_예외() {
    assertThatThrownBy(() -> LottoTickets.of(1500))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("로또 구매 금액은 1000원 단위여야 합니다.");
  }

  @Test
  void 수동_자동_로또_생성() {
    List<Lotto> manualLottos = Arrays.asList(
        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
        new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
    );

    assertThat(LottoTickets.of(manualLottos, 5000).size()).isEqualTo(5);
  }

  @Test
  void 수동_로또_수_초과_예외() {
    List<Lotto> manualLottos = Arrays.asList(
        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
        new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
    );
    assertThatThrownBy(() -> LottoTickets.of(manualLottos, 1000))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("수동 로또 수가 구매 가능한 로또 수를 초과했습니다.");
  }

  @Test
  void 당첨_통계_생성() {
    LottoTickets lottoTickets = LottoTickets.of(5000);

    Map<PrizeRank, Integer> result = lottoTickets.createWinningStatistics(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7)
        .getRankCounts();
    assertThat(result).isNotNull();
    assertThat(result.values().stream().mapToInt(Integer::intValue).sum())
        .isLessThanOrEqualTo(lottoTickets.size());
  }
} 