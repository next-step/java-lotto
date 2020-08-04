package camp.nextstep.edu.rebellion.lotto.domain.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoTicketGeneratorTest {
    @DisplayName("입력한 금액에 맞게 로또가 생성 되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "0:0",
            "1000:1",
            "9500:9",
            "10000:10",
            "10001:10"
        }, delimiter = ':')
    public void purchaseGookLuckTest(int amount, int expected) {
        // when
        LottoTicket result = LottoTicketGenerator.purchaseGoodLuck(amount);

        // then
        assertThat(result.getLottoNumbers()).hasSize(expected);
    }

    @DisplayName("생성된 로또 번호가 올바른지 확인")
    @Test
    public void rangeTest() {
        // given
        int purchaseAmount = 1000;

        // when
        LottoTicket ticket = LottoTicketGenerator.purchaseGoodLuck(purchaseAmount);
        LottoNumber lottoNumber = ticket.getLottoNumbers().get(0);

        // then
        assertThat(lottoNumber.getNumbers()
                .stream()
                .distinct()
                .count()).isEqualTo(6);
        assertThat(lottoNumber.getNumbers()
                .stream()
                .filter(n -> (45 < n || 1 > n))
                .count()).isEqualTo(0);
    }
}
