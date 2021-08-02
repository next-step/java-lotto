package lotto.domain;

import lotto.domain.LottoMachine;
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
    void getPurchaseCountTest(int purchaseAmount, int expected) {
        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);

        assertThat(lottoMachine.getPurchaseLottoCount()).isEqualTo(expected);
    }

    @DisplayName("로또 기계에서 로또번호들을 생성 시 로또번호가 6개 인지 테스트 ")
    @Test
    void generateLottoNumbersTest() {
        LottoMachine lottoMachine = new LottoMachine(14000);

        LottoNumbers lottoNumbers = lottoMachine.generateLottoNumber();

        assertThat(lottoNumbers.size()).isEqualTo(6);
    }
}
//
//
//    @DisplayName("수익률 구하기 테스트")
//    @Test
//    void calculateProfitRateTest() {
//        LottoNumber winningLottoNumber = new LottoNumber(Arrays.asList(8, 21, 23, 41, 42, 43));
//
//        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(8, 21, 23, 41, 42, 43));
//
//        LottoNumber lottoNumber2 = new LottoNumber(Arrays.asList(8, 21, 23, 41, 42, 45));
//
//        LottoNumbers lottoNumbers = LottoNumbers.of(Arrays.asList(lottoNumber, lottoNumber2));
//
//        LottoMachine lottoMachine = new LottoMachine(14000);
//
//        double result = lottoMachine.calculateProfitRate(lottoNumbers.getMatchingRecords(winningLottoNumber));
//
//        assertThat(result).isEqualTo(142964.2857142857);
//
//
//    }
//}
