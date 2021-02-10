package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AutoLottoMachineTest {

    @DisplayName("로또 번호 길이 테스트")
    @Test
    public void generateTicket() {
        AutoLottoMachine autoLottoMachine = new AutoLottoMachine(6);
        assertThat(autoLottoMachine.generateAutoTicket().size()).isEqualTo(6);
    }

    @DisplayName("자동 로또 티켓 생 테스트")
    @Test
    public void generateTicketsbyCount() {
        AutoLottoMachine autoLottoMachine = new AutoLottoMachine(2);
        assertThat(autoLottoMachine.buyTicket().size()).isEqualTo(2);
    }
}
