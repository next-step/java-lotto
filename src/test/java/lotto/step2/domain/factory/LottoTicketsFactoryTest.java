package lotto.step2.domain.factory;

import lotto.step2.domain.LottoTickets;
import lotto.step2.domain.LottoTicketsTest;
import lotto.step2.domain.PaymentInformationTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsFactoryTest {
    @Test
    @DisplayName("자동으로 로또 발급하기.")
    void autoIssueLotto() {
        LottoTickets actualLottoTickets = LottoTicketsFactory.of(paymentPrice -> new LottoTicketsTest().lottoTickets, new PaymentInformationTest().paymentInformation);
        assertThat(actualLottoTickets).isEqualTo(new LottoTicketsTest().lottoTickets);
    }
}