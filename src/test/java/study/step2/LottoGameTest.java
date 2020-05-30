package study.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.step2.domain.LottoGame;
import study.step2.domain.RandomLottoNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    @ParameterizedTest
    @DisplayName("로또 구입금액 입력시 그에 맞는 로또 갯수 구매되는지 테스트")
    @CsvSource(value = {"10000:10", "14000:14", "20000:20", "31500:31"}, delimiter = ':')
    public void moneyBuyLottoTest(String input, int expected){
        assertThat(new LottoGame(input).buyLotto(new RandomLottoNumberGenerator())).hasSize(expected);
    }

    @ParameterizedTest
    @DisplayName("구입금액과 당첨금을 알때 수익률 계산 정확한지 테스트")
    @CsvSource(value = {"14000:5000:0.35", "50000:5000:0.1", "5000:50000:10.0"}, delimiter = ':')
    public void lottoEarningsRateTest(String payMoney, int prizeMoney, double earningsRate){
        // 수익률 = 당첨금/로또구매금액
        assertThat(new LottoGame(payMoney).getEarningsRate(prizeMoney)).isEqualTo(earningsRate);
    }
}
