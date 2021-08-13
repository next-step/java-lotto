package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinnerNumbersTest {
    final WinnerNumbers winnerNumbers = WinnerNumbers.from(LottoTicket.of(1, 2, 3, 4, 5, 6), LottoBall.select(7));

    private static Stream<Arguments> 로또티켓을_입력으로_받으면_등급을_알수있다() {
        return Stream.of(
            Arguments.of(LottoTicket.of(1, 2, 3, 34, 35, 36), Rank.FIFTH),
            Arguments.of(LottoTicket.of(1, 2, 3, 4, 35, 36), Rank.FOURTH),
            Arguments.of(LottoTicket.of(1, 2, 3, 4, 5, 36), Rank.THIRD),
            Arguments.of(LottoTicket.of(1, 2, 3, 4, 5, 7), Rank.SECOND),
            Arguments.of(LottoTicket.of(1, 2, 3, 4, 5, 6), Rank.FIRST)
        );
    }

    @ParameterizedTest
    @MethodSource
    void 로또티켓을_입력으로_받으면_등급을_알수있다(LottoTicket lottoTicket, Rank expected) {
        assertThat(winnerNumbers.decideRank(lottoTicket)).isEqualTo(expected);
    }

}
