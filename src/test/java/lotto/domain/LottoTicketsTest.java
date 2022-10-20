package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.groups.Tuple.tuple;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTicketsTest {

    @Test
    @DisplayName("로또 개수만큼 발급할 수 있다.")
    void create() {
        LottoTickets lottoTickets = LottoTickets.of(14000);
        assertThat(lottoTickets.getTicketCount()).isEqualTo(14);
    }

    @Test
    @DisplayName("1000원 미만은 로또를 구매할 수 없다.")
    void valid() {
        assertThatThrownBy(() -> LottoTickets.of(500))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("6개를 맞추면 1등을 하는 결과가 나온다.")
    void result() {
        List<Integer> list = List.of(1,2,3,4,5,6);
        int bonus = 7;
        LottoTickets lottoTickets = LottoTickets.of(List.of(Lotto.of(list)));

        LottoResult result = lottoTickets.getResult(WinningLotto.of(list, bonus));

        assertThat(result.getStatistics().entrySet())
            .hasSize(6)
            .extracting(Map.Entry::getKey, Map.Entry::getValue)
            .containsExactly(
                tuple(Rank.FIFTH, 0),
                tuple(Rank.FOURTH, 0),
                tuple(Rank.THIRD, 0),
                tuple(Rank.SECOND, 0),
                tuple(Rank.FIRST, 1),
                tuple(Rank.NONE, 0)
            );
    }
}
