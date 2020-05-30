package dev.dahye.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 티켓")
class LottoTicketTest {

    @Test
    @DisplayName("로또 티켓은 6개의 값으로 이루어져 있다.")
    void lotto_ticket_create() {
        assertThat(LottoTicket.issued().validateLottoNumberSize()).isTrue();
    }

    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    @DisplayName("로또 티켓은 모두 다른 숫자로 이루어져 있다.")
    void lotto_ticket_numbers() {
        assertThat(LottoTicket.issued().validateDuplicateNumbers()).isTrue();
    }

}