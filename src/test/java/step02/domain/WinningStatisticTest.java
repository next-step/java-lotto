package step02.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class WinningStatisticTest {
    Lotto winningNumbers;
    Lottos userLottos;
    LottoRewardCollections lottoRewards;
    LottoRewardCollections statisticLottoRewards;

    @BeforeEach
    void setup() {
        winningNumbers = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        userLottos = Lottos.of(
                Arrays.asList(
                        Lotto.of(Arrays.asList(8, 21, 23, 41, 42, 43)),
                        Lotto.of(Arrays.asList(3, 5, 11, 16, 32, 38)),
                        Lotto.of(Arrays.asList(7, 11, 16, 35, 36, 44)),
                        Lotto.of(Arrays.asList(1, 8, 11, 31, 41, 42)),
                        Lotto.of(Arrays.asList(13, 14, 16, 38, 42, 45)),
                        Lotto.of(Arrays.asList(7, 11, 30, 40, 42, 43)),
                        Lotto.of(Arrays.asList(2, 13, 22, 32, 38, 45)),
                        Lotto.of(Arrays.asList(23, 25, 33, 36, 39, 41)),
                        Lotto.of(Arrays.asList(1, 3, 5, 14, 22, 45)),
                        Lotto.of(Arrays.asList(5, 9, 38, 41, 43, 44)),
                        Lotto.of(Arrays.asList(2, 8, 9, 18, 19, 21)),
                        Lotto.of(Arrays.asList(13, 14, 18, 21, 23, 35)),
                        Lotto.of(Arrays.asList(17, 21, 29, 37, 42, 45)),
                        Lotto.of(Arrays.asList(3, 8, 27, 30, 35, 44))
                )
        );
        lottoRewards = LottoRewardCollections.of(
                Arrays.asList(
                        LottoReward.of(3, 5000, 0),
                        LottoReward.of(4, 50000, 0),
                        LottoReward.of(5, 1500000, 0),
                        LottoReward.of(6, 2000000000, 0)
                )
        );
        statisticLottoRewards = LottoRewardCollections.of(
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
        Lotto winningNumbers = Lotto.of(Arrays.asList(1, 2, 3, 4, 5));
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
