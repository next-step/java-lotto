package step4.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또기계")
public class LottoMachineTest {

    LottoMachine lottoMachine;

    @BeforeEach
    public void setUp() {
        int money = 10000;
        int[][] manualLottoNos = new int[3][6];
        manualLottoNos[0] = new int[] { 1, 2, 3, 4, 5, 6 };
        manualLottoNos[1] = new int[] { 7, 8, 9, 10, 11, 12 };
        manualLottoNos[2] = new int[] { 13, 14, 15, 16, 17, 18 };
        lottoMachine = new LottoMachine(money, manualLottoNos);
    }

    @DisplayName("발행")
    @Test
    public void issue() {
        assertThat(lottoMachine.issue()).hasSize(10);
    }

    @DisplayName("수동로또갯수")
    @Test
    public void getManualLottosSize() {
        assertThat(lottoMachine.getManualLottosSize()).isEqualTo(3);
    }

    @DisplayName("자동로또갯수")
    @Test
    public void getAutoLottosSize() {
        assertThat(lottoMachine.getAutoLottosSize()).isEqualTo(7);
    }

}
