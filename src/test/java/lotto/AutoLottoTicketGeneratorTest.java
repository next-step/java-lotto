package lotto;

import lotto.domain.AutoLottoTicketGenerator;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoTicketGeneratorTest {

    @DisplayName("입력한 갯수만큼 티켓을 생성한다")
    @Test
    void extract_six_random_numbers() {
        //Given+When
        List<LottoTicket> tickets = new AutoLottoTicketGenerator().generate(3);
        //Then
        assertThat(tickets.size()).isEqualTo(3);
    }
}
