package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTicketTest {

    @DisplayName("수동_구매한_로또_수_테스트")
    @ParameterizedTest
    @ValueSource(strings = {"4","-1","abc"})
    void purchaseLottoTicketTest(String numberOfManualLottoTicket) {
        assertThatIllegalArgumentException().isThrownBy(()->new LottoTicket(numberOfManualLottoTicket, 3));
    }
}