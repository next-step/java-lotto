package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoPrice;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

  private final LottoService lottoService = new LottoService();

  @Test
  void 로또_티켓_생성() {
    List<Lotto> manualLottos = Arrays.asList(
        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),
        new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12))
    );
    assertThat(lottoService.createLottoTickets(LottoPrice.from(5000), manualLottos).size()).isEqualTo(5);
  }

  @Test
  void 당첨_통계_계산() {
    assertThat(
        lottoService.calculateWinningStatistics(lottoService.createLottoTickets(LottoPrice.from(1000), List.of()),
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)), 7)).isNotNull();
  }
} 