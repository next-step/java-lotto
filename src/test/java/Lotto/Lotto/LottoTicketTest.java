package Lotto.Lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1,2,3,4,5,6=2,3,4,5,6,7=5",
            "1,2,3,4,5,6=7,6,5,4,3,2=5",
            "1,2,3,4,5,6=6,7,8,9,10,11=1",
            "1,2,3,4,5,6=11,10,9,8,7,6=1"
    }, delimiter = '=')
    @DisplayName("몇개의 숫자가 맞았나 확인")
    public void matchTest(String buyNumbers, String winNumbers, Integer matchingCount) {
        LottoTicket lottoTicket = new LottoTicket(buyNumbers);
        LottoWinNumbers lottoWinNumbers = new LottoWinNumbers(winNumbers);
        assertThat(lottoTicket.match(lottoWinNumbers)).isEqualTo(LottoReward.valueOfMatchCount(matchingCount));
    }
}
