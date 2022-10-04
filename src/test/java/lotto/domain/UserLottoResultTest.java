package lotto.domain;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class UserLottoResultTest {

    @ParameterizedTest(name = "당첨된 티켓 등수의 갯수를 센다. {2}")
    @MethodSource(value = "provideTestCountRank")
    void countRank(Money ticketPrice, List<LottoGameRank> ranks, List<Integer> expectedCounts) {
        UserLottoResult userLottoResult = new UserLottoResult(ticketPrice, ranks);

        List<Integer> counts = Stream.of(LottoGameRank.FIRST, LottoGameRank.THIRD, LottoGameRank.FOURTH, LottoGameRank.FIFTH)
            .map(userLottoResult::countRank)
            .collect(toList());

        assertThat(counts).isEqualTo(expectedCounts);
    }

    @ParameterizedTest(name = "수익률을 계산한다. {2}")
    @MethodSource(value = "provideTestReturnRate")
    void calculateReturnRate(Money ticketPrice, List<LottoGameRank> ranks, BigDecimal expectedRate) {
        assertThat(new UserLottoResult(ticketPrice, ranks).calculateReturnRate()).isEqualTo(expectedRate);
    }

    private static Stream<Arguments> provideTestCountRank() {
        Money ticketPrice = new Money(1_000);

        return Stream.of(
            Arguments.of(ticketPrice, List.of(LottoGameRank.FIRST, LottoGameRank.THIRD, LottoGameRank.FOURTH), List.of(1, 1, 1, 0)),
            Arguments.of(ticketPrice, List.of(LottoGameRank.FIRST, LottoGameRank.FIRST, LottoGameRank.FOURTH), List.of(2, 0, 1, 0))
        );
    }

    private static Stream<Arguments> provideTestReturnRate() {
        Money ticketPrice = new Money(1_000);

        return Stream.of(
            Arguments.of(ticketPrice, List.of(LottoGameRank.NONE), BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP)),
            Arguments.of(ticketPrice, List.of(LottoGameRank.FIFTH), new BigDecimal("5").setScale(2, RoundingMode.HALF_UP)),
            Arguments.of(ticketPrice, List.of(LottoGameRank.FOURTH), new BigDecimal("50").setScale(2, RoundingMode.HALF_UP)),
            Arguments.of(ticketPrice, List.of(LottoGameRank.THIRD), new BigDecimal("1500").setScale(2, RoundingMode.HALF_UP)),
            Arguments.of(ticketPrice, List.of(LottoGameRank.FIRST), new BigDecimal("2000000").setScale(2, RoundingMode.HALF_UP))
        );
    }
}
