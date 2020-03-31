package study.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.lotto.domain.*;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private LottoTicketIssuer lottoTicketIssuer;

    @BeforeEach
    void setUp() {
        lottoTicketIssuer =
                () -> new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @DisplayName("입력한 금액만큼의 로또티켓을 생성한다.")
    @ParameterizedTest
    @CsvSource({"14000,14", "3900,3", "200,0"})
    void buy(int amount, int expect) {
        assertThat(
                new Lotto(amount, lottoTicketIssuer).getLottoTickets().size())
                .isEqualTo(expect);
    }

    @DisplayName("당첨번호와 3개 이상 일치하면 당첨된것이다.")
    @Test
    void winning() {
        LottoWinningNumber lottoWinningNumber =
                new LottoWinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 45);
        Lotto lotto = new Lotto(1000, lottoTicketIssuer);
        LottoResult lottoResult = lotto.result(lottoWinningNumber);
        assertThat(lottoResult.getWinningTickets(LottoRank.FIRST).size())
                .isEqualTo(1);
    }
}
