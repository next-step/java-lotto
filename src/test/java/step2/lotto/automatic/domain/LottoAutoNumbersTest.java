package step2.lotto.automatic.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoAutoNumbersTest {

    private static LottoAutoMachine lottoAutoNumbersTest;

    @Test
    public void 자동으로_생성된_번호가_6개가_맞는지() {
        assertThatThrownBy(() ->
                lottoAutoNumbersTest = new LottoAutoMachine(7)
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 로또번호가제대로생성되었는지() {
        lottoAutoNumbersTest = new LottoAutoMachine(45);
        assertThat(lottoAutoNumbersTest.getAutoNumbers(45).size()).isEqualTo(45);
    }
}
