package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 티켓들(LottoTickets) 테스트")
public class LottoTicketsTest {

    private LottoTickets lottoTickets;

    @BeforeEach
    void setUp() {
        lottoTickets = LottoTickets.of(Arrays.asList(
                createLottoTicket(1, 2, 3, 4, 5, 6),
                createLottoTicket(2, 3, 4, 5, 6, 7),
                createLottoTicket(3, 4, 5, 6, 7, 8)
        ));
    }

    @DisplayName("당첨 로또와 비교해서 등수 배열을 구할 수 있다.")
    @Test
    void match() {
        // given
        LottoTicket winningTicket = createLottoTicket(1, 2, 3, 4, 5, 6);
        WinningLotto winningLotto = WinningLotto.of(winningTicket, LottoNumber.valueOf(7));

        // when
        List<Rank> ranks = lottoTickets.match(winningLotto);

        // then
        assertThat(ranks).containsExactly(Rank.FIRST, Rank.SECOND, Rank.FOURTH);
    }

    private LottoTicket createLottoTicket(final int... value) {
        return Arrays.stream(value)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoTicket::of));
    }
}
