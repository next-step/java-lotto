package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("로또 티켓 집합 클래스 테스트")
class LottoTicketsTest {

    @DisplayName("로또 티켓은 1장 이상 구입해야 한다")
    @Test
    void lottoTicketsCreate_fail() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoTickets.create(0))
                .withMessage("로또 티켓은 1장 이상 구입해야 합니다");
    }

    @ParameterizedTest(name = "1개 이상의 로또를 구입하면 로또 티켓 집합 객체가 생성된다")
    @CsvSource(value = {"1:1", "9:9", "20:20"}, delimiter = ':')
    void lottoTicketsCreate_success(int lottoTicketCount, int expected) {
        LottoTickets lottoTickets = LottoTickets.create(lottoTicketCount);
        int ticketCount = lottoTickets.findLottoTicketCount();
        Assertions.assertThat(ticketCount).isEqualTo(expected);
    }
}
