package lotto.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    @Test
    void 초기화_테스트() {
        //given
        LottoMachine.initLottoNumbers();

        //when
        //then
        assertThat(LottoMachine.drawnNumber()).isBetween(1, 45);
    }
}