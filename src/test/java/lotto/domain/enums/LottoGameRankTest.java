package lotto.domain.enums;

import lotto.domain.entity.LottoTicket;
import lotto.domain.vo.LottoNumber;
import lotto.domain.vo.LottoResult;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

class LottoGameRankTest {
    @ParameterizedTest(name = "티켓과 결과가 주어졌을 때 등수 탐색: {2}")
    @MethodSource(value = "provideTicketAndResult")
    void findRank(LottoTicket ticket, LottoResult result, LottoGameRank expectedRank) {
        assertThat(LottoGameRank.findRank(ticket, result)).isEqualTo(expectedRank);
    }

    private static Stream<Arguments> provideTicketAndResult() {
        return Stream.of(
                Arguments.of(new LottoTicket(createLottoNumberList(1, 2, 3, 4, 5, 6)), new LottoResult(List.of(1, 2, 3, 4, 5, 6)), LottoGameRank.FIRST),
                Arguments.of(new LottoTicket(createLottoNumberList(1, 2, 3, 4, 5, 6)), new LottoResult(List.of(1, 2, 3, 4, 5, 7)), LottoGameRank.THIRD),
                Arguments.of(new LottoTicket(createLottoNumberList(1, 2, 3, 4, 5, 6)), new LottoResult(List.of(1, 2, 3, 4, 7, 8)), LottoGameRank.FOURTH),
                Arguments.of(new LottoTicket(createLottoNumberList(1, 2, 3, 4, 5, 6)), new LottoResult(List.of(1, 2, 3, 7, 8, 9)), LottoGameRank.FIFTH),
                Arguments.of(new LottoTicket(createLottoNumberList(1, 2, 3, 4, 5, 6)), new LottoResult(List.of(1, 2, 7, 8, 9, 10)), LottoGameRank.NONE)
        );
    }

    private static List<LottoNumber> createLottoNumberList(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::new)
                .collect(toList());
    }
}
