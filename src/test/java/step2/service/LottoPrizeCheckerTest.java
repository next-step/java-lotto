package step2.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.domain.entity.Lotto;
import step2.domain.entity.LottoTicket;
import step2.domain.vo.LottoPrize;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoPrizeCheckerTest {

    @ParameterizedTest(name = "로또번호: {0}, 당첨번호: {1}, 결과: {2}")
    @MethodSource("provideTestCase")
    void 로또_당첨(Lotto lotto, Lotto winner, LottoPrize expected) {
        final var ticket = new LottoTicket(lotto);

        List<LottoPrize> checker = LottoPrizeChecker.checker(List.of(ticket), winner);
        final var actual = checker.get(0);

        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> provideTestCase() {
        return Stream.of(
                Arguments.arguments(new Lotto(1, 2, 3, 4, 5, 6), new Lotto(1, 2, 3, 4, 5, 6), LottoPrize.FIRST),
                Arguments.arguments(new Lotto(1, 2, 3, 4, 5, 7), new Lotto(1, 2, 3, 4, 5, 6), LottoPrize.SECOND),
                Arguments.arguments(new Lotto(1, 2, 3, 4, 7, 8), new Lotto(1, 2, 3, 4, 5, 6), LottoPrize.THIRD),
                Arguments.arguments(new Lotto(1, 2, 3, 7, 8, 9), new Lotto(1, 2, 3, 4, 5, 6), LottoPrize.FOURTH)
        );
    }
}
