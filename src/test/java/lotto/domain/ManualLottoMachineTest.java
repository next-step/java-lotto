package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ManualLottoMachineTest {

    @DisplayName("수동과 자동 로또 티켓을 생성하는 테스트")
    @Test
    void buyTicketTest() {
        String manualLotto = "1, 2, 3, 4, 5, 6\n2, 3, 4, 5, 6, 7";
        ManualLottoMachine manualLottoMachine = new ManualLottoMachine(manualLotto);
        assertThat(manualLottoMachine.buyTicket(12).size()).isEqualTo(14);
    }

    @DisplayName("수동 로또는 없고 자동 로또 티켓만 생성하는 테스트")
    @Test
    void buyAutoTicketTest() {
        String manualLotto = "";
        ManualLottoMachine manualLottoMachine = new ManualLottoMachine(manualLotto);
        assertThat(manualLottoMachine.buyTicket(12).size()).isEqualTo(12);
    }
}