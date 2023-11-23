package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoCheckerTest {

    @DisplayName("추첨 번호와 당첨번호가 일치하는 개수에 따라서 Rank가 정해진다.")
    @ParameterizedTest
    @MethodSource("lottoNumbersAndRank")
    void test(Rank rank, Rank expected) {
        assertThat(rank).isEqualTo(expected);
    }

    static Stream<Arguments> lottoNumbersAndRank() {
        LottoChecker validator = new LottoChecker(7, 1, 2, 3, 4, 5, 6);
        return Stream.of(
            Arguments.arguments(validator.check(new LottoTicket(1, 2, 3, 4, 5, 6)), Rank.FIRST),
            Arguments.arguments(validator.check(new LottoTicket(1, 2, 3, 4, 5, 7)), Rank.SECOND),
            Arguments.arguments(validator.check(new LottoTicket(1, 2, 3, 4, 5, 8)), Rank.THIRD),
            Arguments.arguments(validator.check(new LottoTicket(1, 2, 3, 4, 7, 9)), Rank.FOURTH),
            Arguments.arguments(validator.check(new LottoTicket(1, 2, 3, 8, 9, 10)), Rank.FIFTH),
            Arguments.arguments(validator.check(new LottoTicket(1, 7, 8, 9, 10, 11)), Rank.NOT)
        );
    }
}
