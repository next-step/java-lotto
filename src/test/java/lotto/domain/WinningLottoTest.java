package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("로또 당첨 테스트")
class WinningLottoTest {

    private WinningLotto winningLotto;

    @BeforeEach
    void setUp() {
        LottoTicket lottoTicket = LottoTicket.from(Set.of(1, 2, 3, 4, 5, 6));
        winningLotto = new WinningLotto(lottoTicket);
    }

    @DisplayName("승리 로또와 일치하는 번호의 개수를 확인 할 수 있다")
    @Test
    void winningLotto_create_success() {
        String winningNumbersString = "1,2,3,4,5,6";

        WinningLotto winningLotto = WinningLottoFactory.create(winningNumbersString);
        LottoTicket lottoTicket = LottoTicket.from(Set.of(1, 2, 3, 4, 5, 7));
        int countOfMatch = winningLotto.countOfMatch(lottoTicket);

        Assertions.assertThat(countOfMatch).isEqualTo(5);
    }

    @ParameterizedTest
    @MethodSource("rankCases")
    @DisplayName("로또 번호 일치 갯수에 따라 로또 당첨 등수를 반환한다")
    void shouldMatchRankByMatchingNumbers(Set<Integer> numbers, WinningRank expectedRank) {
        LottoTicket ticket = LottoTicket.from(numbers);

        WinningRank rank = winningLotto.match(ticket);

        assertEquals(expectedRank, rank);
    }

    static Stream<Arguments> rankCases() {
        return Stream.of(
                Arguments.of(Set.of(1, 2, 3, 4, 5, 6), WinningRank.FIRST),
                Arguments.of(Set.of(1, 2, 3, 4, 5, 7), WinningRank.SECOND),
                Arguments.of(Set.of(1, 2, 3, 4, 10, 11), WinningRank.THIRD),
                Arguments.of(Set.of(1, 2, 3, 11, 12, 13), WinningRank.FOURTH),
                Arguments.of(Set.of(1, 2, 13, 14, 15, 16), WinningRank.NONE),
                Arguments.of(Set.of(1, 12, 13, 14, 15, 16), WinningRank.NONE),
                Arguments.of(Set.of(11, 12, 13, 14, 15, 16), WinningRank.NONE)
        );
    }
}
