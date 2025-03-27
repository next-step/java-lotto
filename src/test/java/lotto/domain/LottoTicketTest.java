package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {

    @RepeatedTest(100)
    @DisplayName("로또 티켓은 1과 45사이의 랜덤한 숫자 6개로 구성된다.")
    void createRandomNumbers() {
        LottoTicket lottoTicket = new LottoTicket();
        assertThat(lottoTicket.issue())
                .hasSize(6)
                .allMatch(number -> number >= 1 && number <= 45);
    }

}