package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoMachineTest {

    @Test
    @DisplayName("입력된 금액만큼 로또 발급")
    public void 금액에_따른_로또_발급_갯수() {
        Assertions.assertThat(LottoMachine.issue(5000).size())
                .isEqualTo(5);
    }
}
