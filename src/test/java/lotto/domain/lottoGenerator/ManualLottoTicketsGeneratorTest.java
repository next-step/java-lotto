package lotto.domain.lottoGenerator;

import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ManualLottoTicketsGeneratorTest {

    @DisplayName("수동으로 로또 번호를 입력해서 로또 티켓을 생성할 수 있다.")
    @Test
    void generate() {

        //given
        List<String> lottoTicketList = new ArrayList<>();
        lottoTicketList.add("1, 2, 3, 4, 5, 6");
        lottoTicketList.add("1, 2, 3, 4, 5, 7");
        ManualLottoTicketsGenerator manualLottoTicketsGenerator = new ManualLottoTicketsGenerator(lottoTicketList);

        //when
        List<LottoTicket> lottoTickets = manualLottoTicketsGenerator.generate();

        //then
        assertThat(lottoTickets.size()).isEqualTo(2);

    }

}