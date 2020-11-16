package humbledude.lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {

    @Test
    public void validNumbers() {
        assertThat(LottoNumbers.of(TestHelper.setOf(1, 2, 3 ,4 ,5, 6)))
                .isInstanceOf(LottoNumbers.class);
    }

    @Test
    public void duplicatedNumbers() {
        assertThatIllegalArgumentException().isThrownBy(
                () -> LottoNumbers.of(TestHelper.setOf(1, 2, 3 ,4 ,6, 6)));
    }
}
