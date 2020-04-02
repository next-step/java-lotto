package study.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    @DisplayName("수익률을 구할 수 있다.")
    @Test
    void getRateOfReturn() {
        WinningLottos winningLottos = new WinningLottos();
        winningLottos
                .addToRank(LottoRank.FIFTH, new Lotto(Arrays.asList(1, 2, 3, 4
                        , 5, 6)));

        LottoResult lottoResult = new LottoResult(winningLottos, 50000);
        assertThat(lottoResult.getRateOfReturn()).isEqualTo(0.1);
    }
}
