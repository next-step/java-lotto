package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketsTest {

    @DisplayName("LottoTickets 생성 테스트")
    @Test
    void lottoGameTicketsCreateTest(){
        // given
        int inputMoneyAmount = 14000;

        // when
        LottoTickets lottoTickets = new LottoTickets(inputMoneyAmount);

        // then
        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(14);
    }
}
