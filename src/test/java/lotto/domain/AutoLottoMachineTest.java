package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AutoLottoMachineTest {

    @DisplayName("로또 번호 길이 테스트")
    @Test
    public void generateTicket() {
        AutoLottoMachine autoLottoMachine = new AutoLottoMachine();
        assertThat(autoLottoMachine.generateAutoTicket().size()).isEqualTo(6);
    }
}
