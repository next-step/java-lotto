package step2.model;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.util.LottoMakeNumbers;

class LottosCalculatorTest {

    private static final Lottos LOTTOS = Lottos.of(Stream.of(
        Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,7")),
        Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,8")),
        Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,40,20,10")),
        Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,30,20,10"))
    ).collect(toList()));

    private static final LottoWinning LOTTO_WINNING = LottoWinning
        .of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,6"), LottoNumber.of(7));

    private static final List<LottoPrize> PRIZE_LIST = LOTTOS.getCalculate(LOTTO_WINNING);

    private static final LottoPrizes LOTTO_RESULT = LottoPrizes
        .of(PRIZE_LIST, LOTTOS.resultLottoGamePayOffRatio(PRIZE_LIST));

    @DisplayName("로또 당첨 수를 구하는 메소드 검증")
    @ParameterizedTest
    @MethodSource("provideWinningLottoCount")
    void 로또_당첨수_테스트(LottoPrizes lottoPrizes, LottoRank rank, long expected) {
        assertEquals(
            lottoPrizes.getLottoPrizes()
                .stream()
                .filter(prize -> prize.getRank().equals(rank))
                .map(LottoPrize::getCount).findFirst().orElse(0L)
            , expected
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
            LOTTOS.getPayoff(PRIZE_LIST),
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
            Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,7,10")),
            Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,3,7,20,10")),
            Lotto.of(LottoMakeNumbers.convertStringToNumbers("1,2,7,30,20,10"))
        ).collect(toList())
    );

    private static final LottoWinning lottoWinning = LottoWinning
        .of(LottoMakeNumbers.convertStringToNumbers("1,2,3,4,5,6"), BONUS_NUMBER);
    private static final LottoWinning lottoWinning2 = LottoWinning
        .of(LottoMakeNumbers.convertStringToNumbers("11,12,13,14,15,16"), BONUS_NUMBER);

    private static final List<LottoPrize> prizeList = lottos.getCalculate(lottoWinning);
    private static final List<LottoPrize> prizeList2 = lottos.getCalculate(lottoWinning2);

    @DisplayName("로또 당첨 금액의 수익률 검증 테스트")
    @ParameterizedTest
    @MethodSource("provideLottoGameAndWinningPrice")
    void 로또_당첨_수익률_테스트(LottoPrizes lottoPrizes, String expected) {
        String payoffRatio = String
            .format(RATIO_FORMAT, lottoPrizes.getPayOffRatio());
        assertEquals(expected, payoffRatio);
    }

    private static Stream<Arguments> provideLottoGameAndWinningPrice() {
        final long payoff = Arrays.stream(LottoRank.values()).mapToLong(LottoRank::getPrice).sum();
        final String payoffRatio1 = String.format(RATIO_FORMAT, payoff / (6.0 * Lotto.PRICE));
        final String payoffRatio2 = "0.00";
        return Stream.of(
            Arguments.of(
                LottoPrizes.of(prizeList, lottos.resultLottoGamePayOffRatio(prizeList))
                , payoffRatio1
            ),
            Arguments.of(
                LottoPrizes.of(prizeList2, lottos.resultLottoGamePayOffRatio(prizeList2))
                , payoffRatio2
            )
        );
    }
}