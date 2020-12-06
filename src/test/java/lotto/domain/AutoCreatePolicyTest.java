package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AutoCreatePolicyTest {
    @DisplayName("Money 객체를 인자로 받아 객체를 생성할 수 있다.")
    @Test
    void createTest() {
        Money money = new Money(10001);

        assertThat(new AutoCreatePolicy(money)).isNotNull();
    }

    @DisplayName("갖고 있는 돈으로 최대한 살 수 있는 LottoTicket을 자동으로 만들 수 있다.")
    @Test
    void createLottoTicketTest() {
        Money money = new Money(10011);
        AutoCreatePolicy autoCreatePolicy = new AutoCreatePolicy(money);
        int expectedSize = 10;

        List<LottoTicket> lottoTickets = autoCreatePolicy.create();

        assertThat(lottoTickets.size()).isEqualTo(expectedSize);
    }
}
