package camp.nextstep.edu.rebellion.lotto.domain.ticket;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketGeneratorTest {
    @DisplayName("입력한 금액에 맞게 로또가 생성 되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "1000:1",
            "9500:9",
            "10000:10",
            "10001:10"
        }, delimiter = ':')
    public void purchaseGookLuckTest(int amount, int expected) {
        //given
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount, 0);

        // when
        LottoTicket result = LottoTicketGenerator.purchaseGoodLuck(purchaseAmount, Collections.emptyList());

        // then
        assertThat(result.getLottos()).hasSize(expected);
    }
}
