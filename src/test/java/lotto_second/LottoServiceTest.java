package lotto_second;

import lotto_second.domain.Lotto;
import lotto_second.domain.LottoTickets;
import lotto_second.service.LottoService;
import lotto_second.util.LottoValidate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

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

    @DisplayName("로또자동 생성 확인")
    @Test
    void generateAutoTicket() {
        LottoService lottoService = new LottoService();
        LottoTickets ticket = lottoService.generateAutoTickets(5);
        assertThat(ticket.size()).isEqualTo(5);
    }

    @DisplayName("수동 로또 티켓 생성 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:7,8,9,10,11,12:2"}, delimiter = ':')
    void parseManualTicketsTest(String input1, String input2, int expected) {
        // given
        List<String> manualInputTicket = Arrays.asList(input1, input2);
        LottoService lottoService = new LottoService();

        // when
        LottoTickets lottoTickets = lottoService.parseManualTickets(manualInputTicket);

        // then
        assertThat(lottoTickets.size()).isEqualTo(expected);
    }

    @DisplayName("수동 로또 티켓 오류 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:7,8,9,10,11,12,55:2"}, delimiter = ':')
    void parseManualTicketsErrorTest(String input1, String input2, int expected) {
        // given
        List<String> manualInputTicket = Arrays.asList(input1, input2);
        LottoService lottoService = new LottoService();
        Class expect = IllegalArgumentException.class;

        // when
        assertThatThrownBy(() -> lottoService.parseManualTickets(manualInputTicket))
                .isInstanceOf(expect);
    }


    @ParameterizedTest(name = "{index} ===> 로또 구입금액 부족, 투입금액 : {0}  ")
    @ValueSource(strings = {"100", "0900", "10"})
    void insufficientAmount(String input) {
        LottoService lottoService = new LottoService();
        Class expect = IllegalArgumentException.class;

        assertThatThrownBy(() -> LottoValidate.maxTicketCount(input))
                .isInstanceOf(expect);
    }

    @ParameterizedTest(name = "{index} ===> 올바르지 않은 로또 가격 입력, 투입금액 : {0}  ")
    @ValueSource(strings = {"가짜", "test", "예외"})
    void invalidLottoPrice(String input) {
        LottoService lottoService = new LottoService();
        Class expect = IllegalArgumentException.class;

        assertThatThrownBy(() -> LottoValidate.maxTicketCount(input))
                .isInstanceOf(expect);
    }

}
