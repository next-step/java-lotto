package lotto;

import lotto.domain.*;
import lotto.dto.LottoStatusResponseDto;
import lotto.service.LottoService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LottoServiceTest {

    @Test
    @DisplayName("Money 객체 전달받으면 로또를 발급한다.")
    void buyLotto() {
        LottoService lottoService = LottoService.buyLotto(new Money(3000), () -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        LottoStatusResponseDto lottoStatusResponseDto = lottoService.buyStatus();
        Assertions.assertThat(lottoStatusResponseDto.getLottoStatus())
                .isEqualTo(
                        List.of(
                                List.of(1, 2, 3, 4, 5, 6),
                                List.of(1, 2, 3, 4, 5, 6),
                                List.of(1, 2, 3, 4, 5, 6)
                        )
                );
    }

    @Test
    @DisplayName("로또 당첨 여부를 판단한다.")
    void matchWinningLotto() {
        LottoService lottoService = LottoService.buyLotto(new Money(3000), () -> new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        WinningLotto first = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
        WinningLotto second = new WinningLotto(List.of(1, 2, 3, 4, 5, 7), 6);

        LottoResults lottoResults = lottoService.matchWinningLotto(first);
        Assertions.assertThat(lottoResults.getLottoResults()).containsEntry(LottoRank.FIRST, 3L);
        LottoResults lottoResults2 = lottoService.matchWinningLotto(second);
        Assertions.assertThat(lottoResults2.getLottoResults()).containsEntry(LottoRank.SECOND, 3L);
    }

    @Test
    @DisplayName("수익률을 계산한다.")
    void profitRate() {
        LottoService lottoService = LottoService.buyLotto(new Money(1000));
        LottoResults lottoResults = new LottoResults(List.of(LottoRank.FIFTH, LottoRank.NONE, LottoRank.FOURTH));
        Assertions.assertThat(lottoService.profitRate(lottoResults).getProfitRate()).isEqualTo(55.0);
    }
}
