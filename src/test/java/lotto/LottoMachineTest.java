package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.domain.LottoMachine;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoMachineTest {

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "1000:1", "5000:5"}, delimiter = ':')
    @DisplayName("금액별 로또 생성 테스트")
    void 금액별_lotto_생성_개수(int price, int ticketCount) {
        assertThat(LottoMachine.purchaseLottoTickets(price)).hasSize(ticketCount);
    }

    @Test
    @DisplayName("1000미만으로 구매시 IllegalArgumentException 발생")
    void 금액_1000_미만_exception() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoMachine.purchaseLottoTickets(999);
        });
    }
}
