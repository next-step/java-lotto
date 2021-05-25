package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {
    @ParameterizedTest
    @CsvSource({"0,0", "1000,1", "25000, 25"})
    void 로또_구입_금액을_입력하면_구입_금액에_해당하는_로또를_발급해야_한다(int 지불금액, int 구입_로또_개수) {
        assertThat(LottoMachine.buyWith(new LottoMoney(지불금액)).size()).isEqualTo(구입_로또_개수);
    }
}
