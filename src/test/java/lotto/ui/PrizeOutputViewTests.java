package lotto.ui;

import lotto.domain.rank.Rank;
import lotto.domain.rank.Ranks;
import lotto.domain.shop.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static lotto.domain.rank.Rank.*;
import static org.assertj.core.api.Assertions.assertThat;

class PrizeOutputViewTests {
    private Ranks ranks;

    @BeforeEach
    public void setup() {
        this.ranks = Ranks.create(Arrays.asList(FIRST, SECOND));
    }

    @DisplayName("Ranks를 전달 받아서 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        assertThat(new PrizeOutputView(ranks)).isNotNull();
    }

    @DisplayName("개별 등수의 결과를 반환한다.")
    @ParameterizedTest
    @MethodSource("ranksAndResults")
    void getIndividualStatistics(Rank rank, String result) {
        PrizeOutputView prizeOutputView = new PrizeOutputView(ranks);
        assertThat(prizeOutputView.getIndividualStatistics(rank)).isEqualTo(result);
    }
    public static Stream<Arguments> ranksAndResults() {
        return Stream.of(
                Arguments.of(FOURTH, "4개 일치 (50000원)- 0개"),
                Arguments.of(THIRD, "5개 일치 (1500000원)- 0개"),
                Arguments.of(SECOND, "5개 일치, 보너스 볼 일치(30000000원)- 1개"),
                Arguments.of(FIRST, "6개 일치 (2000000000원)- 1개")
        );
    }

    @DisplayName("통합 등수의 결과를 반환한다.")
    @Test
    void getTotalStatistics() {
        PrizeOutputView prizeOutputView = new PrizeOutputView(ranks);
        assertThat(prizeOutputView.getTotalStatistics()).isEqualTo("3개 일치 (5000원)- 0개\n" +
                "4개 일치 (50000원)- 0개\n" +
                "5개 일치 (1500000원)- 0개\n" +
                "5개 일치, 보너스 볼 일치(30000000원)- 1개\n" +
                "6개 일치 (2000000000원)- 1개\n");
    }

    @DisplayName("총 당첨 금액을 구할 수 있다.")
    @Test
    void getTotalPrize() {
        PrizeOutputView prizeOutputView = new PrizeOutputView(ranks);
        assertThat(prizeOutputView.getTotalRateOfReturn(new Money(2000)))
                .isEqualTo("총 수익률은 1015000.00입니다.");
    }
}
