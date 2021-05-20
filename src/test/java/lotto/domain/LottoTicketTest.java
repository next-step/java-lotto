package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @DisplayName("로또 티켓 생성하기")
    @Test
    public void createLottoTicket() {
        List<Integer> lottoNumbers = Arrays.asList(1,2,3,4,5,6);

        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        assertThat(lottoTicket.numbers()).hasSize(6);
    }

}
