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
        lottoStatement.judge(new HitCount(4), false);
        assertThat(lottoStatement.accumulatedHitCount(LottoRule.FOUR_HIT)).isEqualTo(1);
        assertThat(lottoStatement.accumulatedHitCount(LottoRule.SIX_HIT)).isEqualTo(0);

        lottoStatement.judge(new HitCount(4), false);
        assertThat(lottoStatement.accumulatedHitCount(LottoRule.FOUR_HIT)).isEqualTo(2);
        assertThat(lottoStatement.accumulatedHitCount(LottoRule.SIX_HIT)).isEqualTo(0);

        lottoStatement.judge(new HitCount(4), true);
        assertThat(lottoStatement.accumulatedHitCount(LottoRule.FOUR_HIT)).isEqualTo(2);

        lottoStatement.judge(new HitCount(5), true);
        assertThat(lottoStatement.accumulatedHitCount(LottoRule.FIVE_HIT_WITH_BONUS)).isEqualTo(1);
    }

    @DisplayName("lotto 당첨금액 테스트")
    @Test
    void calcProceeds() {
        lottoStatement.judge(new HitCount(2), false);
        assertThat(lottoStatement.calcProceeds()).isEqualTo(new Money(0));

        lottoStatement.judge(new HitCount(3), false);
        assertThat(lottoStatement.calcProceeds()).isEqualTo(new Money(5000));

        lottoStatement.judge(new HitCount(3), true);
        assertThat(lottoStatement.calcProceeds()).isEqualTo(new Money(5000));

        lottoStatement.judge(new HitCount(4), false);
        assertThat(lottoStatement.calcProceeds()).isEqualTo(new Money(5000+50000));

        lottoStatement.judge(new HitCount(5), false);
        assertThat(lottoStatement.calcProceeds()).isEqualTo(new Money(5000+50000+1500000));

        lottoStatement.judge(new HitCount(5), true);
        assertThat(lottoStatement.calcProceeds()).isEqualTo(new Money(5000+50000+1500000+30_000_000));
    }
}
