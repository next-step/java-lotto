package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoWinningResultTest {

    private LottoWinningResult lottoWinningResult;

    @BeforeEach
    void setUp() {
        this.lottoWinningResult = new LottoWinningResult(LottoResult.FIRST,1);
    }

    @Test
    @DisplayName("로또 1등결과건수 객체 비교")
    void lottoWinningResult_isEqualTo() {
        LottoWinningResult winningResult = new LottoWinningResult(LottoResult.FIRST,1);

        assertThat(lottoWinningResult).isEqualTo(winningResult);
    }
}
