package lotto.domain;


import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    void isContainTest() {
        LottoMachine lottoMachine = new LottoMachine(Arrays.asList(3, 4, 5, 6, 7, 8), 9);
        Assertions.assertThat(lottoMachine.isContain(3)).isTrue();
    }


    @Test
    void isNotContainTest() {
        LottoMachine lottoMachine = new LottoMachine(Arrays.asList(3, 4, 5, 6, 7, 8), 9);
        Assertions.assertThat(lottoMachine.isContain(45)).isFalse();
    }

    @Test
    void isEqualBonusNumberTest() {
        LottoMachine lottoMachine = new LottoMachine(Arrays.asList(3, 4, 5, 6, 7, 8), 9);
        Assertions.assertThat(lottoMachine.isEqualBonusNumber(9)).isTrue();
    }

    @Test
    void isNotEqualBonusNumberTest() {
        LottoMachine lottoMachine = new LottoMachine(Arrays.asList(3, 4, 5, 6, 7, 8), 9);
        Assertions.assertThat(lottoMachine.isEqualBonusNumber(34)).isFalse();
    }

}