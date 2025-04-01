package lotto.domain.model.game;

import lotto.domain.model.lotto.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameResultTest {

    @DisplayName("로또 게임 결과 생성 테스트")
    @Test
    void createLottoGameResult() {
        LottoGameResult result = new LottoGameResult();

        assertThat(result.getRankCountMap()).isEmpty();
        assertThat(result.getTotalPrize()).isEqualTo(Prize.zero());
    }

    @DisplayName("로또 게임 결과 추가 테스트")
    @ParameterizedTest
    @MethodSource("rankAdditionTestCases")
    void addResult(final Rank[] ranksToAdd, final Rank rankToCheck, final Integer expectedCount) {
        LottoGameResult result = new LottoGameResult();
        
        for (Rank rank : ranksToAdd) {
            result.addResult(rank);
        }

        Map<Rank, Integer> rankCountMap = result.getRankCountMap();
        assertThat(rankCountMap.get(rankToCheck)).isEqualTo(expectedCount);
    }

    private static Stream<Arguments> rankAdditionTestCases() {
        return Stream.of(
                Arguments.of(new Rank[]{Rank.FIRST, Rank.FIRST}, Rank.FIRST, 2),
                Arguments.of(new Rank[]{Rank.FIRST, Rank.THIRD}, Rank.THIRD, 1),
                Arguments.of(new Rank[]{Rank.FIRST, Rank.THIRD}, Rank.SECOND, null)
        );
    }

    @DisplayName("로또 게임 총 상금 계산 테스트")
    @ParameterizedTest
    @MethodSource("prizeCalculationTestCases")
    void getTotalPrize(final Rank[] ranksToAdd, final Prize expectedTotalPrize) {
        LottoGameResult result = new LottoGameResult();
        
        for (Rank rank : ranksToAdd) {
            result.addResult(rank);
        }

        assertThat(result.getTotalPrize()).isEqualTo(expectedTotalPrize);
    }

    private static Stream<Arguments> prizeCalculationTestCases() {
        return Stream.of(
                Arguments.of(
                    new Rank[]{Rank.FIRST, Rank.THIRD, Rank.FIFTH}, 
                    Rank.FIRST.getWinningPrize().add(Rank.THIRD.getWinningPrize()).add(Rank.FIFTH.getWinningPrize())
                ),
                Arguments.of(new Rank[]{Rank.MISS, Rank.MISS}, Prize.zero()),
                Arguments.of(new Rank[]{Rank.FIFTH, Rank.FIFTH}, Rank.FIFTH.getWinningPrize().add(Rank.FIFTH.getWinningPrize()))
        );
    }

    @DisplayName("로또 게임 수익률 계산 테스트")
    @ParameterizedTest
    @MethodSource("yieldCalculationTestCases")
    void getYield(final Rank[] ranksToAdd, final int purchaseAmountValue, final double expectedYield) {
        LottoGameResult result = new LottoGameResult();
        PurchaseAmount purchaseAmount = new PurchaseAmount(purchaseAmountValue);
        
        for (Rank rank : ranksToAdd) {
            result.addResult(rank);
        }

        assertThat(result.getYield(purchaseAmount).getValue()).isEqualTo(expectedYield);
    }

    private static Stream<Arguments> yieldCalculationTestCases() {
        return Stream.of(
                Arguments.of(new Rank[]{Rank.THIRD}, 5000, (double) Rank.THIRD.getWinningPrize().getAmount() / 5000),
                Arguments.of(new Rank[]{Rank.FIFTH}, 1000, (double) Rank.FIFTH.getWinningPrize().getAmount() / 1000),
                Arguments.of(new Rank[]{Rank.MISS}, 1000, 0.0)
        );
    }

} 
