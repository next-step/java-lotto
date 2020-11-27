package step3.lotto.domain.numbers;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoAutoNumbersTest {

    private static LottoMachine lottoAutoNumbersTest;

    @Test
    public void 자동으로_생성된_번호가_6개가_맞는지() {
        assertThatThrownBy(() ->
                lottoAutoNumbersTest = new LottoMachine(7)
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 로또번호가제대로생성되었는지() {
        lottoAutoNumbersTest = new LottoMachine(45);
        assertThat(lottoAutoNumbersTest.getAutoNumbers(45)).isEqualTo(45);
    }
}
