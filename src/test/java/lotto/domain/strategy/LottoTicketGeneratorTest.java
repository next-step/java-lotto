package lotto.domain.strategy;

import lotto.domain.item.LottoTickets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketGeneratorTest {

    @DisplayName("주어진 수 만큼 랜덤 로또를 만들어 낸다")
    @Test
    public void lottoTicketGenerate_success() throws Exception {
        //given
        LottoTicketGenerator generator = new LottoTicketGenerator();

        //when
        LottoTickets tickets = generator.generate(3);

        //then
        assertThat(tickets.size()).isEqualTo(3);
    }

}
