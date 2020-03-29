package study.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.lotto.domain.Lotto;
import study.lotto.domain.LottoTicketIssuer;
import study.lotto.domain.LottoTicket;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private LottoTicketIssuer lottoTicketIssuer;

    @BeforeEach
    void setUp() {
        lottoTicketIssuer = () -> new LottoTicket(new int[]{1, 2, 3, 4, 5, 6});
    }

    @DisplayName("입력한 금액만큼의 로또티켓을 생성한다.")
    @ParameterizedTest
    @CsvSource({"14000,14", "3900,3", "200,0"})
    void buy(int amount, int expect) {
        assertThat(new Lotto(amount, lottoTicketIssuer).getQuantity()).isEqualTo(expect);
    }



}
