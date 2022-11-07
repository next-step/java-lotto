package lotto.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMoneyTest {
    @ParameterizedTest
    @CsvSource(value = {"10000,10", "14500,14", "900,0"}, delimiter = ',')
    @DisplayName("돈으로 몇장의 티켓을 사는지 확인")
    public void buyCountTest(Integer money, Integer ticketCount) {
        LottoMoney lottoMoney = new LottoMoney(money);
        LottoCount lottoCount = lottoMoney.getLottoCount();
        assertThat(lottoCount.getCount()).isEqualTo(ticketCount);
    }
}
