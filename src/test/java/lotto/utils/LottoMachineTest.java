package lotto.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoMachineTest {
    @Test
    void 초기화_테스트() {
        //given
        LottoMachine lottoMachine = new LottoMachine();

        //when
        //then
        assertThat(lottoMachine.drawnLottoNumbers().size()).isEqualTo(6);
    }
}