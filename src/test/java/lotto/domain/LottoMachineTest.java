package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class LottoMachineTest {
    @Test
    @DisplayName("구입금액, 수동 로또 장수로 자동 로또 장수 파악")
    void numberOfAutoLotto() {
        int cost = 14000;
        int numberOfManualLottos = 2;

        LottoMachine machine = new LottoMachine(cost, numberOfManualLottos);

        assertThat(machine.getNumberOfAutoLottos()).isEqualTo(12);
        assertThat(machine.getNumberOfManualLottos()).isEqualTo(2);
    }

    @Test
    @DisplayName("구입금액이 음수인지 체크")
    void validate() {
        assertThatThrownBy(() -> {
            new LottoMachine(-14000);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구입금액이 로또 한장 가격보다 작을 수 없습니다.");
    }

    @Test
    @DisplayName("수동 로또 생성")
    void createManualLottos() {
        int cost = 14000;
        int numberOfMaualLottos = 2;

        LottoMachine machine = new LottoMachine(cost, numberOfMaualLottos);
        Lottos manualLottos = machine.generateLotto(Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12"));

        assertThat(new Lottos(Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12"))).isEqualTo(manualLottos);
    }

    @Test
    @DisplayName("수동 로또 생성 - 입력한 수동 로또 장수보다 번호가 부족할 경우")
    void createManualLottos_exception() {
        int cost = 14000;
        int numberOfManualLottos = 3;

        assertThatThrownBy(() -> {
            LottoMachine machine = new LottoMachine(cost, numberOfManualLottos);
            machine.generateLotto(Arrays.asList("1, 2, 3, 4, 5, 6", "7, 8, 9, 10, 11, 12"));
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("입력한 수동 로또 장수와 수동 로또 번호가 일치하지 않습니다.");
    }

    @Test
    @DisplayName("금액보다 수동 로또를 많이 입력받은 경우")
    void input_exception() {
        int cost = 14000;
        int numberOfManualLottos = 15;

        assertThatThrownBy(() -> {
            new LottoMachine(cost, numberOfManualLottos);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("구입한 로또보다 수동 로또 장수가 많을 수 없습니다.");
    }

}
