package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static lotto.domain.LottoNumber.valueOf;
import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.NO_MATCH;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WinningLottoTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("당첨번호를 전달받아서 등수 반환")
    void match(LottoTicket lottoTicket, Rank rank) {
        WinningLotto winningLotto = new WinningLotto(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)), valueOf(7));

        Assertions.assertThat(winningLotto.match(lottoTicket)).isEqualTo(rank);
    }

    static Stream<Arguments> match() {
        return Stream.of(
                arguments(new LottoTicket(List.of(1, 2, 3, 4, 5, 6)), FIRST),
                arguments(new LottoTicket(List.of(1, 2, 3, 4, 5, 7)), SECOND),
                arguments(new LottoTicket(List.of(1, 2, 3, 4, 5, 8)), THIRD),
                arguments(new LottoTicket(List.of(1, 2, 3, 4, 7, 8)), FOURTH),
                arguments(new LottoTicket(List.of(1, 2, 3, 7, 8, 9)), FIFTH),
                arguments(new LottoTicket(List.of(1, 2, 7, 8, 9, 10)), NO_MATCH)
        );
    }

}
