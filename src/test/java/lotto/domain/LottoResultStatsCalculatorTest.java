package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultStatsCalculatorTest {

    private static final Money LOTTO_FEE = Money.wons(8_000);
    private static List<LottoTicket> purchased;
    private static LottoResultStatsCalculator target;

    private static LottoResultStatsCalculator createTarget(final LottoNumbers winingLottoNumbers) {
        return new LottoResultStatsCalculator(purchased, new WiningLotto(winingLottoNumbers));
    }

    @BeforeEach
    void setUp() {
        purchased = Arrays.asList(
            new LottoTicket(LOTTO_FEE, LottoNumbers.of(1, 2, 3, 4, 5, 6)),
            new LottoTicket(LOTTO_FEE, LottoNumbers.of(7, 8, 9, 10, 11, 12))
        );
        target = createTarget(LottoNumbers.of(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("아무것도 당첨되지 않았을 경우, 모든 당첨 횟수는 ZERO여야 한다")
    @Test
    void computeResultStats_winingNothing() {
        target = createTarget(LottoNumbers.of(10, 15, 20, 25, 30, 35));
        final LottoResultStatistics resultStats = target.computeLottoResultStats();

        assertThat(resultStats.getFirstRankCount()).isZero();
        assertThat(resultStats.getSecondRankCount()).isZero();
        assertThat(resultStats.getThirdRankCount()).isZero();
        assertThat(resultStats.getFourthRankCount()).isZero();
        assertThat(resultStats.getTotalWiningMoney()).isEqualTo(Money.ZERO);
    }

    @DisplayName("1등이 당첨되었을 경우, 1등을 제외한 당첨 횟수는 ZERO여야 한다")
    @Test
    void computeResultStats_winingFirst() {
        target = createTarget(LottoNumbers.of(1, 2, 3, 4, 5, 6));
        final LottoResultStatistics resultStats = target.computeLottoResultStats();

        assertThat(resultStats.getFirstRankCount()).isEqualTo(1);
        assertThat(resultStats.getSecondRankCount()).isZero();
        assertThat(resultStats.getThirdRankCount()).isZero();
        assertThat(resultStats.getFourthRankCount()).isZero();
        assertThat(resultStats.getTotalWiningMoney())
            .isEqualTo(resultStats.getFirstRankPrizeMoney());
    }

    @DisplayName("2등이 당첨되었을 경우, 2등을 제외한 당첨 횟수는 ZERO여야 한다")
    @Test
    void computeResultStats_winingSecond() {
        target = createTarget(LottoNumbers.of(1, 2, 3, 4, 5, 8));
        final LottoResultStatistics resultStats = target.computeLottoResultStats();

        assertThat(resultStats.getFirstRankCount()).isZero();
        assertThat(resultStats.getSecondRankCount()).isEqualTo(1);
        assertThat(resultStats.getThirdRankCount()).isZero();
        assertThat(resultStats.getFourthRankCount()).isZero();
        assertThat(resultStats.getTotalWiningMoney())
            .isEqualTo(resultStats.getSecondRankPrizeMoney());
    }

    @DisplayName("3등이 당첨되었을 경우, 3등을 제외한 당첨 횟수는 ZERO여야 한다")
    @Test
    void computeResultStats_winingThird() {
        target = createTarget(LottoNumbers.of(1, 2, 3, 4, 40, 45));
        final LottoResultStatistics resultStats = target.computeLottoResultStats();

        assertThat(resultStats.getFirstRankCount()).isZero();
        assertThat(resultStats.getSecondRankCount()).isZero();
        assertThat(resultStats.getThirdRankCount()).isEqualTo(1);
        assertThat(resultStats.getFourthRankCount()).isZero();
        assertThat(resultStats.getTotalWiningMoney())
            .isEqualTo(resultStats.getThirdRankPrizeMoney());
    }

    @DisplayName("4등이 당첨되었을 경우, 4등을 제외한 당첨 횟수는 ZERO여야 한다")
    @Test
    void computeResultStats_winingFourth() {
        target = createTarget(LottoNumbers.of(1, 2, 3, 30, 40, 45));
        final LottoResultStatistics resultStats = target.computeLottoResultStats();

        assertThat(resultStats.getFirstRankCount()).isZero();
        assertThat(resultStats.getSecondRankCount()).isZero();
        assertThat(resultStats.getThirdRankCount()).isZero();
        assertThat(resultStats.getFourthRankCount()).isEqualTo(1);
        assertThat(resultStats.getTotalWiningMoney())
            .isEqualTo(resultStats.getFourthRankPrizeMoney());
    }

    @DisplayName("복수의 로또가 당첨되었을 경우, 각 등수의 당첨 횟수를 반환해야 한다")
    @Test
    void computeResultStats_winingAll() {
        purchased = Arrays.asList(
            // First
            new LottoTicket(Money.ONE, LottoNumbers.of(1, 2, 3, 4, 5, 6)),
            // Second
            new LottoTicket(Money.ONE, LottoNumbers.of(1, 2, 3, 4, 5, 7)),
            // Third
            new LottoTicket(Money.ONE, LottoNumbers.of(1, 2, 3, 4, 40, 45)),
            new LottoTicket(Money.ONE, LottoNumbers.of(1, 2, 3, 4, 35, 45)),
            // Fourth
            new LottoTicket(Money.ONE, LottoNumbers.of(1, 2, 3, 20, 40, 45)),
            new LottoTicket(Money.ONE, LottoNumbers.of(1, 20, 30, 40, 5, 6)),
            new LottoTicket(Money.ONE, LottoNumbers.of(10, 20, 30, 4, 5, 6)),
            // Nothing
            new LottoTicket(Money.ONE, LottoNumbers.of(1, 2, 30, 35, 40, 45)),
            new LottoTicket(Money.ONE, LottoNumbers.of(1, 20, 30, 35, 40, 45)),
            new LottoTicket(Money.ONE, LottoNumbers.of(10, 20, 30, 35, 40, 45))
        );
        target = new LottoResultStatsCalculator(
            purchased,
            new WiningLotto(LottoNumbers.of(1, 2, 3, 4, 5, 6))
        );
        final LottoResultStatistics resultStats = target.computeLottoResultStats();

        final Money expectedTotalWiningMoney = resultStats
            .getFirstRankPrizeMoney().multiply(resultStats.getFirstRankCount())
            .plus(resultStats.getSecondRankPrizeMoney().multiply(resultStats.getSecondRankCount()))
            .plus(resultStats.getThirdRankPrizeMoney().multiply(resultStats.getThirdRankCount()))
            .plus(resultStats.getFourthRankPrizeMoney().multiply(resultStats.getFourthRankCount()));

        assertThat(resultStats.getFirstRankCount()).isEqualTo(1);
        assertThat(resultStats.getSecondRankCount()).isEqualTo(1);
        assertThat(resultStats.getThirdRankCount()).isEqualTo(2);
        assertThat(resultStats.getFourthRankCount()).isEqualTo(3);
        assertThat(resultStats.getTotalWiningMoney()).isEqualTo(expectedTotalWiningMoney);
    }


    @DisplayName("당첨 되지 않았을 경우, 수익률은 0이어야 한다")
    @Test
    void computeProfitRate_zero() {
        target = createTarget(LottoNumbers.of(10, 15, 20, 25, 30, 35));
        assertThat(target.computeProfitRate()).isZero();
    }

    @DisplayName("로또 구입 금액보다, 로또 당첨 상금이 낮을때, 수익률은 1이하여야 한다")
    @Test
    void computeProfitRate_lessThanOne() {
        target = createTarget(LottoNumbers.of(1, 2, 3, 10, 15, 20));
        assertThat(target.computeProfitRate()).isLessThan(Double.valueOf(1));
    }

    @DisplayName("로또 구입 금액과, 로또 당첨 상금이 같으면, 수익률은 1이여야 한다")
    @Test
    void computeProfitRate_one() {
        final LottoTicket purchased = new LottoTicket(
            Money.wons(5_000),
            LottoNumbers.of(1, 2, 3, 4, 5, 6));

        target = new LottoResultStatsCalculator(
            Collections.singletonList(purchased),
            new WiningLotto(LottoNumbers.of(1, 2, 3, 10, 15, 20))
        );

        assertThat(target.computeProfitRate()).isEqualTo(Double.valueOf(1));
    }

    @DisplayName("로또 구입 금액보다, 로또 당첨 상금이 높으면, 수익률은 1이상이여야 한다")
    @Test
    void computeProfitRate_greaterThanOne() {
        target = createTarget(LottoNumbers.of(1, 2, 3, 4, 5, 6));
        assertThat(target.computeProfitRate()).isGreaterThan(Double.valueOf(1));
    }

}