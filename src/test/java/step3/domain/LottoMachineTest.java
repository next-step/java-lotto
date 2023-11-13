package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoMachineTest {
    private final int MONEY_3000_WON = 3_000;
    private final LottoMachine lottoMachine = new LottoMachine();

    @Test
    @DisplayName("로또 머신 생성 테스트")
    void create() {
        assertThat(lottoMachine).isNotNull();
    }

    @Test
    @DisplayName("로또 머신은 로또를 1개 이상 생성할 수 있다.")
    void createLottoes() {
        assertThat(lottoMachine.createLottos(MONEY_3000_WON).getLottos())
                .hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("입력금액은 최소 로또 한장금액 이상이어야한다.")
    void inputCheck(int inputMoney) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoMachine.createLottos(inputMoney));
    }

    @ParameterizedTest
    @DisplayName("입력금액은 로또한장 금액으로 나누어 떨어져야한다.")
    @ValueSource(ints = {1_001, 1_002, 1_003})
    void inputCheck2(int inputMoney) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoMachine.createLottos(inputMoney));
    }



}
