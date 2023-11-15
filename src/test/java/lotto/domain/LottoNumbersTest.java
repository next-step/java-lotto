package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumbersTest {
    @DisplayName("로또번호가 있으면 true를 반환한다.")
    @Test
    void containsTest() {
        final LottoNumbers lottoNumbers = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

        final boolean result = lottoNumbers.contains(3);

        assertThat(result).isTrue();
    }

    @DisplayName("로또번호는 6개여야 한다.")
    @Test
    void createTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumbers(Arrays.asList(3,4));
        });
    }

    @DisplayName("로또번호는 1이상 45이하 여야 한다.")
    @Test
    void lottoRangeTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumbers(Arrays.asList(-1, 47));
        });
    }
}