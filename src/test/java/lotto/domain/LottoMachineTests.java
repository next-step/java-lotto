package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTests {
    @DisplayName("구입 금액을 넣었을때 올바른 개수가 return 되는 지 test")
    @ParameterizedTest
    @CsvSource(value = {"14000,14", "14500,14", "100000,100"})
    void getPurchaseCountTest(int purchaseAmount, int expected){
        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);

        assertThat(lottoMachine.getPurchaseLottoCount()).isEqualTo(expected);
    }


    @DisplayName("랜덤 번호 테스트")
    @Test
    void generateLottoNumberTest() {
        LottoMachine lottoMachine = new LottoMachine(14000);

        LottoNumber lottoNumber = lottoMachine.generateLottoNumber();

        System.out.println("lotto Number : " + lottoNumber.value());
    }

    @DisplayName("수익률 구하기 테스트")
    @Test
    void calculateProfitRateTest(){
        LottoNumber winningLottoNumber = new LottoNumber(Arrays.asList(8, 21, 23, 41, 42, 43));

        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(8, 21, 23, 41, 42, 43));

        LottoNumber lottoNumber2 = new LottoNumber(Arrays.asList(8, 21, 23, 41, 42, 45));

        LottoNumbers lottoNumbers = LottoNumbers.of(Arrays.asList(lottoNumber, lottoNumber2));

        WinningStatistics winningStatistics = new WinningStatistics(winningLottoNumber, lottoNumbers);

        LottoMachine lottoMachine = new LottoMachine(14000);

        double result = lottoMachine.calculateProfitRate(winningStatistics);

        assertThat(result).isEqualTo(142964.29);


    }
}
