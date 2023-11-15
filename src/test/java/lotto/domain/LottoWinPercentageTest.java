package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinPercentageTest {

    @Test
    @DisplayName("로또 구입 금액과 로또 당첨 통계를 기준으로 총 수익률을 구한다.")
    void success_lotto_win_percentage() {
        List<LottoWinResult> lottoWinResults = List.of(
                new LottoWinResult(3L, 1L),
                new LottoWinResult(4L, 0L),
                new LottoWinResult(5L, 0L),
                new LottoWinResult(6L, 0L)
        );

        LottoWinPercentage lottoWinPercentage = new LottoWinPercentage(14000, lottoWinResults);
        assertThat(lottoWinPercentage.getRate()).isEqualTo(0.35d);
        assertThat(lottoWinPercentage.isLowerStandard()).isTrue();
    }

}