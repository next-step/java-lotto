package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static lotto.domain.LottoRank.MATCH_3;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class LottoNumbersTest {

    @Test
    public void 로또번호_6개생성_테스트() {
        LottoNumbers ln = new LottoNumbers();
        assertThat(ln.numbers()).hasSize(6);
    }

    @Test
    public void 로또번호_정렬테스트() {
        LottoNumbers numbers = LottoNumbers.fromIntegers(Arrays.asList(6, 5, 3, 4, 2, 1));

        LottoNumbers orderedNumbers = LottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertArrayEquals(numbers.numbers().toArray(), orderedNumbers.numbers().toArray());
    }

    @Test
    public void 로또번호_동등성_테스트() {
        LottoNumbers numbers1 = LottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoNumbers numbers2 = LottoNumbers.fromIntegers(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(numbers1.equals(numbers2)).isTrue();
    }

    @Test
    public void 로또번호_불일치_테스트() {
        LottoNumbers numbers1 = LottoNumbers.fromIntegers(Arrays.asList(6, 5, 3, 4, 2, 1));
        LottoNumbers numbers2 = LottoNumbers.fromIntegers(Arrays.asList(16, 15, 13, 14, 12, 11));

        assertThat(numbers1.equals(numbers2)).isFalse();
    }
}
