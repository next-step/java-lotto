package lotto.domain;

import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@SuppressWarnings("NonAsciiCharacters")
class ResultTest {

    @DisplayName("객체 생성")
    @Test
    void create() {
        assertThat(new Result()).isInstanceOf(Result.class);
    }

    @DisplayName("수익률을 가져온다.")
    @Test
    void calculateEarningsRate_수익률() {
        Lottos lottos = new Lottos(
                Arrays.asList(
                        new Lotto(Arrays.asList(5, 10, 15, 20, 1, 2)),
                        new Lotto(Arrays.asList(5, 10, 15, 1, 2, 3)),
                        new Lotto(Arrays.asList(5, 10, 1, 2, 3, 4)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 6, 7))
                )
        );
        Lotto winningLotto = new Lotto(Arrays.asList(5, 10, 15, 20, 25, 30));
        WinningsStatistics winningsStatistics = new WinningsStatistics(winningLotto, new LottoNumber(35));
        Result result = winningsStatistics.makeStatisticsWinnings(lottos);

        assertThat(result.calculateTotalWinningMoney()).isEqualTo(13.75);
    }


    @DisplayName("등수정보를 가져온다.")
    @Test
    void makeStatisticsWinnings_등수정보() {
        Lottos lottos = new Lottos(
                Arrays.asList(
                        new Lotto(Arrays.asList(5, 10, 15, 20, 25, 30)),
                        new Lotto(Arrays.asList(5, 10, 15, 20, 25, 35)),
                        new Lotto(Arrays.asList(5, 10, 15, 20, 25, 1)),
                        new Lotto(Arrays.asList(5, 10, 15, 20, 1, 2)),
                        new Lotto(Arrays.asList(5, 10, 15, 1, 2, 3)),
                        new Lotto(Arrays.asList(5, 10, 1, 2, 3, 4)),
                        new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))
                )
        );
        Lotto winningLotto = new Lotto(Arrays.asList(5, 10, 15, 20, 25, 30));
        WinningsStatistics winningsStatistics = new WinningsStatistics(winningLotto, new LottoNumber(35));
        Result result = winningsStatistics.makeStatisticsWinnings(lottos);

        assertAll(
                () -> AssertionsForClassTypes.assertThat(result.getRankHitsCount(Rank.MISS)).isEqualTo(2),
                () -> AssertionsForClassTypes.assertThat(result.getRankHitsCount(Rank.FIFTH)).isEqualTo(1),
                () -> AssertionsForClassTypes.assertThat(result.getRankHitsCount(Rank.FOURTH)).isEqualTo(1),
                () -> AssertionsForClassTypes.assertThat(result.getRankHitsCount(Rank.THIRD)).isEqualTo(1),
                () -> AssertionsForClassTypes.assertThat(result.getRankHitsCount(Rank.SECOND)).isEqualTo(1),
                () -> AssertionsForClassTypes.assertThat(result.getRankHitsCount(Rank.FIRST)).isEqualTo(1)
        );
    }

}
