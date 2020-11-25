package humbledude.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {

    @Test
    public void sameNumber_exception() {
        int[] rawNumbers = {1, 2, 3, 4, 5, 5};
        Set<LottoNumber> lottoNumberSet = TestHelper.setOf(rawNumbers);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(lottoNumberSet));
    }

    @Test
    public void outOfBound_exception() {
        int[] rawNumbers = {1, 2, 3, 4, 5, 6, 7};
        Set<LottoNumber> lottoNumberSet = TestHelper.setOf(rawNumbers);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumbers(lottoNumberSet));
    }

    @Test
    public void contains() {
        int[] rawNumbers = {1, 2, 3, 4, 5, 6};
        LottoNumbers lottoNumbers = new LottoNumbers(TestHelper.setOf(rawNumbers));

        assertThat(lottoNumbers.contains(LottoNumber.of(1)))
                .isTrue();
    }
}
