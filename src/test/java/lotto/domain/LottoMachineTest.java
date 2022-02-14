
package lotto.domain;


import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    private LottoMachine lottoMachine;

    @BeforeEach
    public void init() {
        List<LottoNumber> winningLottoNumbers =
            Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(8), new LottoNumber(9), new LottoNumber(10));
        this.lottoMachine = new LottoMachine(winningLottoNumbers, 11);
    }

    @Test
    void isContainTest() {
        Assertions.assertThat(lottoMachine.isContain(new LottoNumber(3))).isTrue();
    }


    @Test
    void isNotContainTest() {
        Assertions.assertThat(lottoMachine.isContain(new LottoNumber(45))).isFalse();
    }

    @Test
    void isEqualBonusNumberTest() {
        Assertions.assertThat(lottoMachine.isEqualBonusNumber(new LottoNumber(11))).isTrue();
    }

    @Test
    void isNotEqualBonusNumberTest() {
        Assertions.assertThat(lottoMachine.isEqualBonusNumber(new LottoNumber(34))).isFalse();
    }

}
