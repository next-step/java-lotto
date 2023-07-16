package lotto;

import lotto.domain.*;
import lotto.response.LottoStatusResponse;
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
        LottoStatusResponse lottoStatusResponse = lottoService.buyStatus();
        Assertions.assertThat(lottoStatusResponse.getLottoStatus())
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
        Assertions.assertThat(lottoResults.getLottoResults()).containsEntry(LottoRank.FIRST, new Count(3));
        LottoResults lottoResults2 = lottoService.matchWinningLotto(second);
        Assertions.assertThat(lottoResults2.getLottoResults()).containsEntry(LottoRank.SECOND, new Count(3));
    }
}
