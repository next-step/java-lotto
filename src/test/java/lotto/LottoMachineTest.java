package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoMachineTest {

    @DisplayName("구입 금액만큼 로또를 발행한다")
    @Test
    void generateLottos() {
        List<Lotto> lottos = LottoMachine.generateLottos(1000);
        assertThat(lottos).hasSize(1);
    }

    @DisplayName("구입 금액이 1000원 단위가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 900, 1500})
    void invalidMoney(int money) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoMachine.generateLottos(money))
                .withMessageContaining("1000원 단위");
    }

}
