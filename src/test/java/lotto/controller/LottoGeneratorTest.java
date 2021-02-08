package lotto.controller;

import lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {
    @DisplayName("수동구매 시, 입력 한 문자열로 부터 티켓 제대로 생성하는지")
    @Test
    void rawToTicket() {
        LottoTicket ticket = LottoGenerator.rawToTicket("1, 2, 3, 4, 5, 6");
        LottoTicket answerTicket = new LottoTicket("1, 2, 3, 4, 5, 6");
        assertThat(ticket).isEqualToComparingFieldByField(answerTicket);
    }
}