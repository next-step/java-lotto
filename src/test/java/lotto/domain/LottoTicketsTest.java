package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTicketsTest {

  @Test
  void 가격으로_로또_티켓_생성() {
    assertThat(LottoTickets.of(5000).size()).isEqualTo(5);
  }

  @ParameterizedTest
  @ValueSource(ints = {999, 1500})
  void 잘못된_가격으로_로또_티켓_생성_시_예외_발생(int price) {
    assertThatThrownBy(() -> LottoTickets.of(price))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage(price < 1000 ?
            "로또 구매 금액은 1000원 이상이어야 합니다." :
            "로또 구매 금액은 1000원 단위여야 합니다.");
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
  void 수동_로또_목록_null_예외() {
    assertThatThrownBy(() -> LottoTickets.of(null, 5000))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("수동 로또 목록이 null입니다.");
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
    Lotto winningNumbers = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    LottoStatistics statistics = LottoTickets.of(5000).createWinningStatistics(winningNumbers, 7);

    assertThat(statistics).isNotNull();
  }

  @Test
  void 당첨_번호_null_예외() {
    assertThatThrownBy(() -> LottoTickets.of(5000).createWinningStatistics(null, 7))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessage("당첨 번호가 null입니다.");
  }

  @Test
  void 로또_티켓_목록_조회() {
    assertThat(LottoTickets.of(5000).getLottoTickets()).hasSize(5);
  }
} 