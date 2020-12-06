package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsFactoryTest {
    @DisplayName("Money를 인자로 받아 구매가능한 최대수의 LottoTicket 컬렉션을 반환한다.")
    @Test
    void createAutoTest() {
        Money money = new Money(10001);
        int expectedSize = 10;

        List<LottoTicket> lottoTickets = LottoTicketsFactory.createAuto(money);

        assertThat(lottoTickets.size()).isEqualTo(expectedSize);
    }
}
