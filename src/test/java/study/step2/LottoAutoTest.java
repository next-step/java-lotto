package study.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAutoTest {

    @ParameterizedTest
    @DisplayName("로또 구입금액 입력시 그에 맞는 로또 갯수 구매되는지 테스트")
    @CsvSource(value = {"10000:10", "14000:14", "20000:20", "31500:31"}, delimiter = ':')
    public void moneyBuyLottoTest(int input, int expected){
        assertThat(new LottoGame(input).buyLotto(new RandomLottoNumberGenerator())).hasSize(expected);
    }

    @RepeatedTest(20)
    @DisplayName("로또 티켓은 6개의 번호로 되어 있는지 테스트")
    public void lottoNumberCountTest(){
        assertThat(new RandomLottoNumberGenerator().getLottoNumbers()).hasSize(6);
    }

    @RepeatedTest(20)
    @DisplayName("랜덤으로 이루어진 로또 번호 각각은 중복되지 않는지 테스트")
    public void lottoTicketNumberDuplicationTest(){
        List<Integer> deduplicationNumbers =  new RandomLottoNumberGenerator().getLottoNumbers()
                .stream()
                .distinct()
                .collect(Collectors.toList());
        assertThat(deduplicationNumbers).hasSize(6);
    }

    @Test
    @DisplayName("로또번호 일치 갯수에 맞는 당첨금 수령하는지 테스트")
    public void lottoPrizeMoneyTest(){
        assertThat(WinningTable.findRanking(6).getPrizeMoney()).isEqualTo(2000000000);
    }

    @ParameterizedTest
    @DisplayName("구입금액과 당첨금을 알때 수익률 계산 정확한지 테스트")
    @CsvSource(value = {"14000:5000:0.35", "50000:5000:0.1", "5000:50000:10.0"}, delimiter = ':')
    public void lottoEarningsRateTest(int payMoney, int prizeMoney, double earningsRate){

        // 수익률 = 당첨금/로또구매금액
        assertThat(new LottoGame(payMoney).getEarningsRate(prizeMoney)).isEqualTo(earningsRate);
    }
}
