package lotto.lotto;

import lotto.helper.Generator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 구매 정보를 담고 있는 로또 클래스")
public class LottoTest {

    @DisplayName("로또 구매 정보는 구매 금액과 로또 티켓 그룹을 가지고 생성 한다.")
    @Test
    void initLotto() {
        int payment = 10_000;
        LottoTickets lottoTickets = LottoTickets.from(Generator.lottoTicketList(5));

        assertThat(Lotto.init(payment, lottoTickets)).isNotNull();
    }
}
