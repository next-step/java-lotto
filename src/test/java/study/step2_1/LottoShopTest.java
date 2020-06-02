package study.step2_1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import study.step1.StringAddCalculator;
import study.step2_1.domain.LottoShop;
import study.step2_1.domain.LottoTickets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoShopTest {

    @ParameterizedTest
    @DisplayName("로또 구입금액이 1000원보다 적을 경우 예외발생 테스트")
    @ValueSource(ints = {100, 800, 990})
    public void buyLottoTicketsExceptionTest(long price){
        assertThatThrownBy(() -> new LottoShop().buyLottoTickets(price))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("로또 구입금액 입력시 그에 맞는 로또 갯수 구매되는지 테스트")
    @CsvSource(value = {"10000:10", "14000:14", "20000:20", "31500:31"}, delimiter = ':')
    public void buyLottoTicketsTest(long price, int lottoCounting){
        LottoTickets lottoTickets = new LottoShop().buyLottoTickets(price);
        assertThat(lottoTickets.countLottoTickets()).isEqualTo(lottoCounting);
    }
}
