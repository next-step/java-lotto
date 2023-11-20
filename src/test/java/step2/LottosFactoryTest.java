package step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.lotto.domain.LottoNumberRandomGenerator;
import step2.lotto.domain.LottosFactory;

class LottosFactoryTest {

    @Test
    @DisplayName("Lotto Ticket Count 만큼 Lotto 객체가 생성되어야 한다.")
    void createLottoTicketCount() {
        int lottoTicketCount = 10;
        assertThat(LottosFactory.createLottos(lottoTicketCount, new LottoNumberRandomGenerator()))
            .hasSize(10);
    }

}