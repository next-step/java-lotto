package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @DisplayName("로또 번호가 없으면 로또 번호를 생성할 수 없다.")
    @Test
    void canNotCreateLottoNumbersIfLottoNumbersIsNull() {
        assertThatThrownBy(() -> LottoNumbers.newInstance(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 6개가 아니면 로또 번호를 생성할 수 없다.")
    @Test
    void canNotCreateLottoNumbersIfUnless6LottoNumbers() {
        assertThatThrownBy(() -> LottoNumbers.newInstance(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoNumbers.newInstance(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 번호가 있으면 로또 번호를 생성할 수 없다.")
    @Test
    void canNotCreateLottoNumbersIfContainDuplicateNumbers() {
        assertThatThrownBy(() -> LottoNumbers.newInstance(Arrays.asList(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호를 생성할 수 있다.")
    @Test
    void canCreateLottoNumbers() {
        assertThat(LottoNumbers.newInstance(Arrays.asList(1, 2, 3, 4, 5, 6))).isNotNull();
    }

    @DisplayName("로또 번호를 출력할 수 있다.")
    @Test
    void canPrintLottoNumbersToString() {
        assertThat(LottoNumbers.newInstance(Arrays.asList(1, 2, 3, 4, 5, 6)).toString())
                .isEqualTo("[1, 2, 3, 4, 5, 6]");
    }
}
