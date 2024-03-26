package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;
import lotto.domain.WinningCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoMachineTest {
    @ParameterizedTest
    @CsvSource(value = {"14000:14", "1000:1", "5000:5"}, delimiter = ':')
    @DisplayName("금액별 로또 생성 갯수 테스트")
    void 금액별_lotto_생성_개수(int price, int ticketCount) {
        assertThat(LottoMachine.getTicketsCount(price)).isEqualTo(ticketCount);
    }

    @Test
    @DisplayName("로또 생성 테스트")
    void lotto_생성_개수_테스트(){
        assertThat(LottoMachine.purchaseLottoTickets(14)).hasSize(14);
    }
}
