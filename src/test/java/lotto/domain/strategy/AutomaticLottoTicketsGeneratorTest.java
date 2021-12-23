package lotto.domain.strategy;

import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AutomaticLottoTicketsGeneratorTest {

    @DisplayName("생성자에 전달한 로또티켓 개수만큼 랜덤으로 티켓을 생성한다.")
    @Test
    void generate() {
        //given
        AutomaticLottoTicketsGenerator generator = new AutomaticLottoTicketsGenerator(3);

        //when
        List<LottoTicket> lottoTickets = generator.generate();

        //then
        assertThat(lottoTickets.size()).isEqualTo(3);
    }

}