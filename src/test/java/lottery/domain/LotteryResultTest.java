package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LotteryResultTest {

    @ParameterizedTest
    @MethodSource("lotteryResultSource")
    void conversionTest(PurchasePrice purchasePrice, LotteryTicket winningTicket, LotteryTickets lotteryTickets,
        HashMap<Integer, Long> matchedNumbersAndCount, float earningRatio) {
        LotteryResult lotteryResult = LotteryResult.from(purchasePrice, winningTicket, lotteryTickets);
        LotteryResult expected = LotteryResult.from(matchedNumbersAndCount, earningRatio);

        assertThat(lotteryResult).isEqualTo(expected);
    }

    private static Stream<Arguments> lotteryResultSource() {
        final PurchasePrice purchasePrice = PurchasePrice.of(10000);
        final LotteryTicket winningTicket = LotteryTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));

        final LotteryTicket oneNumberMatchedTicket = LotteryTicket.of(Arrays.asList(1, 7, 8, 9, 10, 11));
        final LotteryTicket twoNumbersMatchedTicket = LotteryTicket.of(Arrays.asList(1, 2, 8, 9, 10, 11));
        final LotteryTicket threeNumbersMatchedTicket = LotteryTicket.of(Arrays.asList(1, 2, 3, 9, 10, 11));
        final LotteryTicket fourNumbersMatchedTicket = LotteryTicket.of(Arrays.asList(1, 2, 3, 4, 10, 11));
        final LotteryTicket fiveNumbersMatchedTicket = LotteryTicket.of(Arrays.asList(1, 2, 3, 4, 5, 11));
        final LotteryTicket sixNumbersMatchedTicket = LotteryTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));

        final HashMap<Integer, Long> oneNumberMatchedResultMap = new HashMap<Integer, Long>() {{
            put(1, 1L);
        }};

        final HashMap<Integer, Long> twoNumbersMatchedResultMap = new HashMap<Integer, Long>() {{
            put(2, 1L);
        }};

        final HashMap<Integer, Long> threeNumbersMatchedResultMap = new HashMap<Integer, Long>() {{
            put(3, 1L);
        }};

        final HashMap<Integer, Long> fourNumbersMatchedResultMap = new HashMap<Integer, Long>() {{
            put(4, 1L);
        }};

        final HashMap<Integer, Long> fiveNumbersMatchedResultMap = new HashMap<Integer, Long>() {{
            put(5, 1L);
        }};

        final HashMap<Integer, Long> sixNumbersMatchedResultMap = new HashMap<Integer, Long>() {{
            put(6, 1L);
        }};

        return Stream.of(
            Arguments.arguments(purchasePrice, winningTicket, LotteryTickets.create(Arrays.asList(oneNumberMatchedTicket)),
                oneNumberMatchedResultMap, 0f),
            Arguments.arguments(purchasePrice, winningTicket, LotteryTickets.create(Arrays.asList(twoNumbersMatchedTicket)),
                twoNumbersMatchedResultMap, 0f),
            Arguments.arguments(purchasePrice, winningTicket, LotteryTickets.create(Arrays.asList(threeNumbersMatchedTicket)),
                threeNumbersMatchedResultMap, 0.5f),
            Arguments.arguments(purchasePrice, winningTicket, LotteryTickets.create(Arrays.asList(fourNumbersMatchedTicket)),
                fourNumbersMatchedResultMap, 5f),
            Arguments.arguments(purchasePrice, winningTicket, LotteryTickets.create(Arrays.asList(fiveNumbersMatchedTicket)),
                fiveNumbersMatchedResultMap, 150f),
            Arguments.arguments(purchasePrice, winningTicket, LotteryTickets.create(Arrays.asList(sixNumbersMatchedTicket)),
                sixNumbersMatchedResultMap, 200_000f)
        );
    }
}
