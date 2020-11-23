package humbledude.lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumberSetTest {

    @Test
    public void sameNumber_exception() {
        int[] rawNumbers = {1, 2, 3, 4, 5, 5};
        Set<LottoNumber> lottoNumberSet = TestHelper.setOf(rawNumbers);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumberSet(lottoNumberSet));
    }

    @Test
    public void outOfBound_exception() {
        int[] rawNumbers = {1, 2, 3, 4, 5, 6, 7};
        Set<LottoNumber> lottoNumberSet = TestHelper.setOf(rawNumbers);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumberSet(lottoNumberSet));
    }

    @Test
    public void contains() {
        int[] rawNumbers = {1, 2, 3, 4, 5, 6};
        LottoNumberSet lottoNumberSet = new LottoNumberSet(TestHelper.setOf(rawNumbers));

        assertThat(lottoNumberSet.contains(LottoNumber.of(1)))
                .isTrue();



    }
}
