package step2;

import org.junit.jupiter.api.Test;
import step2.domain.LottoNumbers;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {

    @Test
    void constructor() {
        assertThat(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void constructorThrowException() {
        assertThatThrownBy(() -> new LottoNumbers(Arrays.asList(1)));
        assertThatThrownBy(() -> new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7)));
    }

    @Test
    void matchCount() {
        assertThat(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)).matchCount(Arrays.asList(1, 7, 8, 9, 10, 11))).isEqualTo(1);
        assertThat(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)).matchCount(Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(6);
    }

    @Test
    void compare() {
        assertThat(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)).compare(Arrays.asList(1, 2, 3, 4, 5, 6))).isTrue();
        assertThat(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)).compare(Arrays.asList(1, 2, 3, 4, 5, 7))).isFalse();
    }
}
