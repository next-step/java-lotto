package lotto_auto;

import lotto_auto.domain.Lotto;
import lotto_auto.domain.LottoTickets;
import lotto_auto.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LottoServiceTest {

    @DisplayName("로또 1매 생성 확인")
    @Test
    void generateTicket() {
        LottoService lottoService = new LottoService();
        Lotto ticket = lottoService.generateTicket();
        assertThat(ticket.getNumbers().size()).isEqualTo(6);
    }

    @DisplayName("로또 구매 확인")
    @Test
    void generateTickets() {
        LottoService lottoService = new LottoService();
        LottoTickets lottoTickets = lottoService.generateTickets("5000");
        assertNotNull(lottoTickets);
        assertThat(lottoTickets.size()).isEqualTo(5);
    }

    @DisplayName("로또 구입 금액 부족")
    @ParameterizedTest
    @ValueSource(strings = {"100", "0900", "10"})
    void insufficientAmount(String input) {
        LottoService lottoService = new LottoService();
        Class expect = IllegalArgumentException.class;

        assertThatThrownBy(() -> lottoService.generateTickets(input))
                .isInstanceOf(expect);
    }

    @DisplayName("올바르지 않은 로또 가격 입력")
    @ParameterizedTest
    @ValueSource(strings = {"가짜", "test", "예외"})
    void invalidLottoPrice(String input) {
        LottoService lottoService = new LottoService();
        Class expect = IllegalArgumentException.class;

        assertThatThrownBy(() -> lottoService.generateTickets(input))
                .isInstanceOf(expect);
    }

}
