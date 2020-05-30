package dev.dahye.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 티켓")
class LottoTicketTest {
    private static final int LOTTO_TICKET_SIZE = 6;

    @Test
    @DisplayName("로또 티켓은 6개의 값으로 이루어져 있다.")
    void lotto_ticket_create() {
        assertThat(LottoTicket.issued().validateLottoNumberSize()).isTrue();
    }

    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    @DisplayName("로또 티켓은 모두 다른 숫자로 이루어져 있다.")
    void lotto_ticket_numbers() {
        LottoTicket lottoTicket = LottoTicket.issued();

        Set<Integer> lottoNumbers = new HashSet<>(lottoTicket.getLottoNumbers());

        assertThat(lottoNumbers.size()).isEqualTo(LOTTO_TICKET_SIZE);
    }

    @Test
    @DisplayName("로또 티켓의 번호는 오름차순 정렬이 되어야 한다.")
    void lotto_numbers_asc() {
        LottoTicket lottoTicket = LottoTicket.issued();
        List<Integer> lottoNumbers = lottoTicket.getLottoNumbers();

        for (int i = 0; i < lottoNumbers.size() - 1; i++) {
            assertThat(lottoNumbers.get(i)).isLessThan(lottoNumbers.get(i + 1));
        }
    }

}