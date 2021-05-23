package lottoauto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatementTest {

    @DisplayName("lotto 당첨횟수 룰 테스트")
    @Test
    void judge() {
        LottoStatement lottoStatement = new LottoStatement();
        lottoStatement.judge(new HitCount(4));
        assertThat(lottoStatement.accumulatedHitCount(LottoRule.FOUR_HIT)).isEqualTo(1);
        assertThat(lottoStatement.accumulatedHitCount(LottoRule.SIX_HIT)).isEqualTo(0);
        lottoStatement.judge(new HitCount(4));
        assertThat(lottoStatement.accumulatedHitCount(LottoRule.FOUR_HIT)).isEqualTo(2);
        assertThat(lottoStatement.accumulatedHitCount(LottoRule.SIX_HIT)).isEqualTo(0);
    }
}
