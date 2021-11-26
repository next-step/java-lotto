package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step3.model.LottoBundle;
import step3.model.LottoMachine;
import step3.model.Money;

@DisplayName("LottoMachine 클래스 테스트")
public class LottoMachineTest {

    @DisplayName("purchaseLottos 메서드 테스트")
    @ParameterizedTest(name = "[{index}] money = {0}, lottoCount = {1}")
    @CsvSource(value = {
        "999, 0",
        "1000, 1",
        "14000, 14"
    })
    void purchaseLotto(int inputMoney, int lottoCount) {
        LottoBundle lottoBundle = LottoMachine.purchaseLotto(new Money(inputMoney));
        assertThat(lottoBundle.getLottoList().size()).isEqualTo(lottoCount);
    }
}
