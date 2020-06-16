package step2.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.util.LottoMakeNumbers;

import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTotalCalculatorTest {

    private static final LottoTotalCalculator LOTTO_RESULT = LottoTotalCalculator.of(
            Lottos.of(Stream.of(
                    Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,7")),
                    Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,8")),
                    Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,40,20,10")),
                    Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,30,20,10"))
            ).collect(toList())),
            LottoWinning.of(
                    Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,6")),
                    LottoNumber.of(7)
            )
    );

    @DisplayName("로또 당첨 수를 구하는 메소드 검증")
    @ParameterizedTest
    @MethodSource("provideWinningLottoCount")
    void 로또_당첨수_테스트(LottoTotalCalculator lottoTotalCalculator, LottoRank rank, long expected) {
        assertEquals(
                lottoTotalCalculator.stream()
                        .filter(prize -> prize.getRank().equals(rank))
                        .map(LottoPrize::getCount).findFirst().orElse(0L),
                expected
        );
    }

    private static Stream<Arguments> provideWinningLottoCount() {
        return Stream.of(
                Arguments.of(LOTTO_RESULT, LottoRank.MATCH_BONUS, 1),
                Arguments.of(LOTTO_RESULT, LottoRank.MATCH_FIVE, 1),
                Arguments.of(LOTTO_RESULT, LottoRank.MATCH_THREE, 2)
        );
    }

    @DisplayName("로또 당첨 금액을 구하는 테스트")
    @Test
    void 로또_당첨_금액_테스트() {
        long expected = LottoRank.MATCH_BONUS.getPrice() + LottoRank.MATCH_FIVE.getPrice() + (LottoRank.MATCH_THREE.getPrice() * 2);
        assertEquals(
                LOTTO_RESULT.getPayoff(),
                expected
        );
    }

    private static final String RATIO_FORMAT = "%.2f";
    private static final LottoNumber BONUS_NUMBER = LottoNumber.of(7);
    private static final Lottos lottos = Lottos.of(
            Stream.of(
                    Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,6")),
                    Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,7")),
                    Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,10")),
                    Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,20,10")),
                    Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,30,20,10"))
            ).collect(toList())
    );

    @DisplayName("로또 당첨 금액의 수익률 검증 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoGameAndWinningPrice")
    void 로또_당첨_수익률_테스트(LottoTotalCalculator lottoResult, String expected) {
        String payoffRatio = String.format(RATIO_FORMAT, lottoResult.resultLottoGamePayOffRatio());
        assertEquals(expected, payoffRatio);
    }

    private static Stream<Arguments> provideLottoGameAndWinningPrice() {
        final long payoff = LottoRank.stream().mapToLong(LottoRank::getPrice).sum();
        final String payoffRatio1 = String.format(RATIO_FORMAT, payoff / (5.0 * Lotto.PRICE));
        final String payoffRatio2 = "0.00";
        return Stream.of(
                Arguments.of(
                        LottoTotalCalculator.of(
                                lottos,
                                LottoWinning.of(Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,6")), BONUS_NUMBER)
                        ),
                        payoffRatio1
                ),
                Arguments.of(
                        LottoTotalCalculator.of(
                                lottos,
                                LottoWinning.of(Lotto.of(LottoMakeNumbers.convertStringToNumbers("11,12,13,14,15,16")), BONUS_NUMBER)
                        ),
                        payoffRatio2
                )
        );
    }
}