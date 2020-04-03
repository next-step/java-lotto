package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private LottoResult lottoResult;

    @BeforeEach
    private void setup() {
        lottoResult = new LottoResult(Arrays.asList(Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST));
    }

    @Test
    public void getTotalWinningMoney() {
        assertThat(lottoResult.getTotalWinningMoney()).isEqualTo(2_001_555_000);
    }
}
