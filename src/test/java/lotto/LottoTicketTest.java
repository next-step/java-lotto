package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTicketTest {

    @DisplayName(value = "티켓 번호가 6개가 생성되었는지 체크")
    @Test
    void 로또_티켓_1개_생성() {
        // when
        List<Integer> ticket = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoTicket autoTicket = LottoTicket.newTicket(ticket);

        // then
        assertThat(autoTicket.size()).isEqualTo(LottoTicket.LOTTO_TICKET_SIZE);
    }

    @DisplayName(value = "티켓 번호가 데이터 정확성 체크")
    @Test
    void 티켓_데이터_정확성() {
        // given
        List<Integer> testTicket = Arrays.asList(31, 45, 30, 22, 21, 1);
        LottoTicket testLottoTicket = LottoTicket.newTicket(testTicket);

        // when
        LottoTicketCreatable lottoTicketCreatable = new LottoTicketCreatable() {
            @Override
            public LottoTicket createTicket() {
                return testLottoTicket;
            }

            @Override
            public LottoTickets createTickets(int purchaseNumber) {
                List<LottoTicket> ticketList = new ArrayList<>();
                for (int i = 0; i < purchaseNumber; i++) {
                    ticketList.add(createTicket());
                }

                return LottoTickets.newTickets(ticketList);
            }
        };

        // then
        assertThat(lottoTicketCreatable.createTicket()).isEqualTo(testLottoTicket);
    }

    @Test
    void 로또_번호가_6개가_아니면_예외() {
        // given
        List<Integer> ticket = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // when
        assertThatThrownBy(() -> {
            LottoTicket.newTicket(ticket);
        // then
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_번호가_중복되면_예외() {
        // given
        List<Integer> ticket = Arrays.asList(1, 2, 3, 4, 5, 5);

        // when
        assertThatThrownBy(() -> {
            LottoTicket.newTicket(ticket);
            // then
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName(value = "지난 주 당첨 번호가 45보다 크거나 1보다 작으면 예외")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    void 지난주_당첨_번호의_범위_체크(int number) {
        // given
        List<Integer> ticket = Arrays.asList(1, 2, 3, 4, 5, number);

        // when
        assertThatThrownBy(() -> {
            LottoTicket.newTicket(ticket);
            // then
        }).isInstanceOf(IllegalArgumentException.class);
    }
}