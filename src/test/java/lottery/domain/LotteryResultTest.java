package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LotteryResultTest {

    @ParameterizedTest
    @MethodSource("lotteryResultSource")
    void conversionTest(PurchasePrice purchasePrice, WinningLotteryNumbers winningLotteryNumbers, LotteryTickets lotteryTickets,
        Map<Rank, Long> rankToCount, float earningRatio) {
        LotteryResult lotteryResult = LotteryResult.of(purchasePrice, winningLotteryNumbers, lotteryTickets);
        LotteryResult expected = LotteryResult.of(rankToCount, earningRatio);

        assertThat(lotteryResult).isEqualTo(expected);
    }

    private static Stream<Arguments> lotteryResultSource() {
        final PurchasePrice purchasePrice = PurchasePrice.from(10000);
        final LotteryTicket winningTicket = LotteryTicket.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        final WinningLotteryNumbers winningLotteryNumbers = WinningLotteryNumbers.of(winningTicket, LotteryNumber.from(45));

        final LotteryTicket missTicket = LotteryTicket.from(Arrays.asList(7, 8, 9, 10, 11, 12));
        final LotteryTicket fifthTicket = LotteryTicket.from(Arrays.asList(1, 2, 3, 9, 10, 11));
        final LotteryTicket fourthTicket = LotteryTicket.from(Arrays.asList(1, 2, 3, 4, 10, 11));
        final LotteryTicket thirdTicket = LotteryTicket.from(Arrays.asList(1, 2, 3, 4, 5, 11));
        final LotteryTicket secondTicket = LotteryTicket.from(Arrays.asList(1, 2, 3, 4, 5, 45));
        final LotteryTicket firstTicket = LotteryTicket.from(Arrays.asList(1, 2, 3, 4, 5, 6));

        return Stream.of(
            Arguments.arguments(purchasePrice, winningLotteryNumbers, LotteryTickets.create(PurchasePrice.from(1000), Arrays.asList(missTicket)),
                getEnumMap(Rank.MISS, 1L), 0f),
            Arguments.arguments(purchasePrice, winningLotteryNumbers, LotteryTickets.create(PurchasePrice.from(1000), Arrays.asList(fifthTicket)),
                getEnumMap(Rank.FIFTH, 1L), 0.5f),
            Arguments.arguments(purchasePrice, winningLotteryNumbers, LotteryTickets.create(PurchasePrice.from(1000), Arrays.asList(fourthTicket)),
                getEnumMap(Rank.FOURTH, 1L), 5f),
            Arguments.arguments(purchasePrice, winningLotteryNumbers, LotteryTickets.create(PurchasePrice.from(1000), Arrays.asList(thirdTicket)),
                getEnumMap(Rank.THIRD, 1L), 150f),
            Arguments.arguments(purchasePrice, winningLotteryNumbers, LotteryTickets.create(PurchasePrice.from(1000), Arrays.asList(secondTicket)),
                getEnumMap(Rank.SECOND, 1L), 3000f),
            Arguments.arguments(purchasePrice, winningLotteryNumbers, LotteryTickets.create(PurchasePrice.from(1000), Arrays.asList(firstTicket)),
                getEnumMap(Rank.FIRST, 1L), 200_000f)
        );
    }

    private static Map<Rank, Long> getEnumMap(Rank rank, Long count) {
        return new EnumMap<Rank, Long>(Rank.class) {{
            put(rank, count);
        }};
    }
}
