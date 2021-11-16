package lotto.step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ProfitTest {

    private Lotteries lotteries;

    @BeforeEach
    void init() {
        Lotto lotto1 = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12));
        Lotto lotto3 = new Lotto(Arrays.asList(13, 14, 15, 16, 17, 18));
        Lotto lotto4 = new Lotto(Arrays.asList(19, 20, 21, 22, 23, 24));
        Lotto lotto5 = new Lotto(Arrays.asList(24, 25, 26, 27, 28, 29));
        lotteries = new Lotteries(Arrays.asList(lotto1, lotto2, lotto3, lotto4, lotto5));
    }

    @ParameterizedTest
    @MethodSource("provideWinnerNumberRate")
    @DisplayName("당첨번호와 비교 했을때, 로또구매 금액과 당첨수에 따른 총 수익률 계산")
    void getRateOfReturn(String provided, double rate) {
        Statics statics = new Statics(provided, lotteries);
        Profit profit = new Profit(statics, 14000);
        assertThat(profit.getRateOfProfit()).isEqualTo(rate);
    }

    private static Stream<Arguments> provideWinnerNumberRate() {
        return Stream.of(
                Arguments.of("1, 2, 3, 43, 44, 45", 0.35),         // 3개일치 - 1개 로또 당첨
                Arguments.of("7, 8, 9, 10, 44, 45", 3.57),         // 4개일치 - 1개 로또 당첨
                Arguments.of("13, 14, 15, 16, 17, 45", 107.14),    // 5개일치 - 1개 로또 당첨
                Arguments.of("19, 20, 21, 22, 23, 24", 142857.14), // 6개일치 - 1개 로또 당첨
                Arguments.of("1, 2, 3, 7, 8, 9", 0.71),            // 3개,3개 - 2개 로또 당첨
                Arguments.of("22, 23, 24, 25, 26, 27", 3.92)       // 3개,4개 - 2개 로또 당첨
        );
    }

}