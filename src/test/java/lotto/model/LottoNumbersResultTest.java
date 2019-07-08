package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersResultTest {

    LottoResult lottoResult;

    @BeforeEach
    void setUp() {
        this.lottoResult = new LottoResult();
    }

    @Test
    void addWinningCount() {
        lottoResult.addWinningCount(3);
        lottoResult.addWinningCount(4);
        lottoResult.addWinningCount(5);
        lottoResult.addWinningCount(6);
        assertThat(lottoResult.getWinningCount3()).isEqualTo(1);
        assertThat(lottoResult.getWinningCount4()).isEqualTo(1);
        assertThat(lottoResult.getWinningCount5()).isEqualTo(1);
        assertThat(lottoResult.getWinningCount6()).isEqualTo(1);
    }
}
