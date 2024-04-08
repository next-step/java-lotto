package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @Test
    void 로또_숫자_6자리_발급(){
        LottoTicket lottoTicket = new LottoTicket();
        List<Integer> lottoNums = lottoTicket.issueTicket();
        assertThat(lottoNums).hasSize(6);
    }

}
