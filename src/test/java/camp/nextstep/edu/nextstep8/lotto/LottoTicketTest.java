package camp.nextstep.edu.nextstep8.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketTest {
    @DisplayName("구매금액 만큼 로또 티켓이 잘 생성 되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "10000:10",
            "10001:10",
            "10999:10",
            "10999:10",
            "9999:9",
            "1000:1"
    }, delimiter = ':')
    public void makeLottoTicketTest(int amount, int expectCount) {
        // when
        LottoTicket lottoTicket = new LottoTicket(amount);

        // then
        assertThat(lottoTicket.getLottoNumbers().size()).isEqualTo(expectCount);
    }

    @DisplayName("구매금액이 1000원 이하일 경우 예외")
    @Test
    public void makeLottoTicketThrownTest() {
        assertThatThrownBy(() -> new LottoTicket(999))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 구매 금액은 최소 1000원 입니다");
    }
}
