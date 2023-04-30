package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("로또 티켓 집합 클래스 테스트")
class LottoTicketsTest {

    @DisplayName("로또 티켓 구입은 1000원 보다 적으면 실패한다")
    @Test
    void lottoTicketsCreate_fail() {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoTickets.create(900))
                .withMessage("티켓 구입 금액은 최소 1000원 이상 이여야 합니다");
    }

    @ParameterizedTest(name = "1000원 이상의 로또 티켓을 구입하면 성공한다")
    @CsvSource(value = {"1000:1", "9000:9", "20000:20"}, delimiter = ':')
    void lottoTicketsCreate_success(int lottoTicketCount, int expected) {
        LottoTickets lottoTickets = LottoTickets.create(lottoTicketCount);
        int ticketCount = lottoTickets.findLottoTicketCount();
        Assertions.assertThat(ticketCount).isEqualTo(expected);
    }
}
