package step02.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step02.Mock;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class WinningStatisticTest {
    Lotto winningNumbers;
    Lottos userLottos;
    LottoRewards lottoRewards;
    LottoRewards statisticLottoRewards;

    @BeforeEach
    void setup() {
        winningNumbers = Lotto.of(Mock.makeWinningNumbers());
        userLottos = Lottos.of(Mock.makeLottos());
        lottoRewards = LottoRewards.of(
                Arrays.asList(
                        LottoReward.of(3, 5000, 0),
                        LottoReward.of(4, 50000, 0),
                        LottoReward.of(5, 1500000, 0),
                        LottoReward.of(6, 2000000000, 0)
                )
        );
        statisticLottoRewards = LottoRewards.of(
                Arrays.asList(
                        LottoReward.of(3, 5000, 1),
                        LottoReward.of(4, 50000, 0),
                        LottoReward.of(5, 1500000, 0),
                        LottoReward.of(6, 2000000000, 0)
                )
        );
    }

    @DisplayName("생성자(금주의 당첨 번호)")
    @Test
    public void test_WinningStatistic_Constructor() {
        assertThat(WinningStatistic.of(winningNumbers, userLottos, lottoRewards))
                .isEqualTo(WinningStatistic.of(winningNumbers, userLottos, lottoRewards));
    }

    @DisplayName("사용자의 로또 번호들과 금주의 당첨번호를 비교해 로또의 결과를 리턴")
    @Test
    public void test_compare() {
        Lotto winningNumbers = Lotto.of(Mock.makeLotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        WinningStatistic winningStatistic = WinningStatistic.of(winningNumbers, userLottos, lottoRewards);

        assertThat(winningStatistic.execute())
                .isEqualTo(WinningStatistic.of(winningNumbers, userLottos, statisticLottoRewards));
    }

    @DisplayName("수익률을 계산해 주는 기능")
    @Test
    public void test_calculateGainRate() {
        int LOTTO_PRICE = 1000;
        WinningStatistic winningStatistic = WinningStatistic.of(winningNumbers, userLottos, statisticLottoRewards);
        assertThat(winningStatistic.calculateGainRate(LOTTO_PRICE))
                .isEqualTo(0.35714285714285715);
    }
}
