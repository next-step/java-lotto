package lottoAuto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {
    private int countMatchWinningNumbers;
    private boolean hasBonusBall;

    @BeforeEach
    public void set() {
        countMatchWinningNumbers = 5;
        hasBonusBall = false;
    }

    @DisplayName("LottoResult객체를 생성한다.")
    @Test
    public void lottoResultTest() {
        assertThat(new LottoResult(countMatchWinningNumbers, hasBonusBall)).isInstanceOf(LottoResult.class);
    }

    @DisplayName("Rank객체를 참조하여 등수를 구한다.")
    @Test
    public void findByRankTest() {
        LottoResult lottoResult = new LottoResult(countMatchWinningNumbers, hasBonusBall);
        assertThat(lottoResult.findByRank()).isEqualTo(Rank.THIRD);
    }
}
