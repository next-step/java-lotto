package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoPrizeTest {
    @DisplayName("로또 당첨 금액 검증 테스트")
    @ParameterizedTest
    @MethodSource("provideTotalPrice")
    void 로또_당첨_금액_테스트(long totalPrice, long expected) {
        assertEquals(expected, totalPrice);
    }

    private static Stream<Arguments> provideTotalPrice() {
        return Stream.of(
                Arguments.of(
                        LottoPrize.of(LottoRank.MATCH_SIX, 1).getTotalPrize(),
                        LottoRank.MATCH_SIX.getPrice() * 1
                ),
                Arguments.of(
                        LottoPrize.of(LottoRank.MATCH_BONUS, 2).getTotalPrize(),
                        LottoRank.MATCH_BONUS.getPrice() * 2
                ),
                Arguments.of(
                        LottoPrize.of(LottoRank.MATCH_FIVE, 3).getTotalPrize(),
                        LottoRank.MATCH_FIVE.getPrice() * 3
                ),
                Arguments.of(
                        LottoPrize.of(LottoRank.MATCH_FOUR, 4).getTotalPrize(),
                        LottoRank.MATCH_FOUR.getPrice() * 4
                ),
                Arguments.of(
                        LottoPrize.of(LottoRank.MATCH_THREE, 5).getTotalPrize(),
                        LottoRank.MATCH_THREE.getPrice() * 5
                )
        );
    }
}
