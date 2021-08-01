package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTests {
    @DisplayName("구입 금액을 넣었을때 올바른 개수가 return 되는 지 test")
    @ParameterizedTest
    @CsvSource(value = {"14000,14", "14500,14", "100000,100"})
    void getPurchaseCountTest(int purchaseAmount, int expected){
        LottoMachine lottoMachine = new LottoMachine(purchaseAmount);

        assertThat(lottoMachine.getPurchaseLottoCount()).isEqualTo(expected);
    }


}
