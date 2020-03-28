package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMachineTest {

    @Test
    @DisplayName("로또기계 생성 테스트")
    void createLotooMachineTest() {
        assertThat(
                new LottoMachine(1000)
        );
    }
}
