package lotto.domain.lotto;

import lotto.domain.lotto.ticket.LottoTicket;
import lotto.domain.lotto.ticket.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @Test
    @DisplayName("")
    void 문자열_생성자_생성_테스트() {
        List<String> input = Arrays.asList("1,2,3,4,5,6", "7,8,9,10,11,12");
        LottoTickets lottoTickets = LottoTickets.fromStringList(input);

        assertThat(lottoTickets).isEqualTo(new LottoTickets(List.of(new LottoTicket(1,2,3,4,5,6), new LottoTicket(7,8,9,10,11,12))));
    }

}
