package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoNumbersTest {

    @Test
    @DisplayName("숫자가 1 ~ 45 사이인 경우")
    void create() {
        assertThat(LottoNumbers.of(1, 2, 3, 4, 5, 6)).isNotNull();
        assertThat(LottoNumbers.of(40, 41, 42, 43, 44, 45)).isNotNull();
    }

    @Test
    @DisplayName("숫자가 1 ~ 45 사이가 아닌 경우")
    void create_outOfRange() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.of(0, 1, 2, 3, 4, 5));
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.of(-1, 2, 3, 4, 5, 6));
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.of(41, 42, 43, 44, 45, 46));
    }

    @Test
    @DisplayName("숫자가 6개인 경우")
    void create_size() {
        assertThat(LottoNumbers.of(1, 2, 3, 4, 5, 6)).isNotNull();
        assertThat(LottoNumbers.of(40, 41, 42, 43, 44, 45)).isNotNull();
    }

    @Test
    @DisplayName("숫자가 6개가 아닌 경우")
    void create_sizeNot6() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.of(1, 2, 3, 4, 5));
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.of(1, 2, 3, 4, 5, 6, 7));
    }

    @Test
    @DisplayName("숫자가 중복된 경우")
    void create_duplicated() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.of(1, 1, 2, 3, 4, 5));
    }
}
