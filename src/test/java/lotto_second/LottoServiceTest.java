package lotto_second;

import lotto_second.domain.Lotto;
import lotto_second.service.LottoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoServiceTest {

    @DisplayName("로또 1매 생성 확인")
    @Test
    void generateTicket() {
        LottoService lottoService = new LottoService();
        Lotto ticket = lottoService.generateTicket();
        assertThat(ticket.getNumbers().size()).isEqualTo(6);
    }


    @ParameterizedTest(name = "{index} ===> 로또 구입금액 부족, 투입금액 : {0}  ")
    @ValueSource(strings = {"100", "0900", "10"})
    void insufficientAmount(String input) {
        LottoService lottoService = new LottoService();
        Class expect = IllegalArgumentException.class;

        assertThatThrownBy(() -> lottoService.generateTickets(input))
                .isInstanceOf(expect);
    }

    @ParameterizedTest(name = "{index} ===> 올바르지 않은 로또 가격 입력, 투입금액 : {0}  ")
    @ValueSource(strings = {"가짜", "test", "예외"})
    void invalidLottoPrice(String input) {
        LottoService lottoService = new LottoService();
        Class expect = IllegalArgumentException.class;

        assertThatThrownBy(() -> lottoService.generateTickets(input))
                .isInstanceOf(expect);
    }

}
