package lottoauto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoStatementTest {

    LottoStatement lottoStatement;

    @BeforeEach
    void setUp() {
        lottoStatement = new LottoStatement();
    }

    @DisplayName("lotto 당첨횟수 룰 테스트")
    @Test
    void judge() {
        lottoStatement.judge(new HitCount(4));
        assertThat(lottoStatement.accumulatedHitCount(LottoRule.FOUR_HIT)).isEqualTo(1);
        assertThat(lottoStatement.accumulatedHitCount(LottoRule.SIX_HIT)).isEqualTo(0);

        lottoStatement.judge(new HitCount(4));
        assertThat(lottoStatement.accumulatedHitCount(LottoRule.FOUR_HIT)).isEqualTo(2);
        assertThat(lottoStatement.accumulatedHitCount(LottoRule.SIX_HIT)).isEqualTo(0);
    }

    @DisplayName("lotto 당첨금액 테스트")
    @Test
    void calcProeeds() {
        lottoStatement.judge(new HitCount(2));
        lottoStatement.judge(new HitCount(3));
        lottoStatement.judge(new HitCount(4));
        lottoStatement.judge(new HitCount(5));

        assertThat(lottoStatement.calcProceeds()).isEqualTo(new Money(5000+50000+1500000));
    }
}
