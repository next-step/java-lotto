package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    @ParameterizedTest
    @ValueSource(strings = {"3, 5, 9, 1", "10, 32, 35, 40, 43"})
    void 입력_로또_번호가_6개가_아닐때(String lottoNumberText) {
        assertThatThrownBy(() -> new LottoNumbers(lottoNumberText))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3, 5, 9, 40, 90, 0", "0, 4, 9, 15, 90, 100"})
    void 로또_번호가_정상범위를_벗어날때(String lottoNumberText) {
        assertThatThrownBy(() -> new LottoNumbers(lottoNumberText))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"3, 5, 9, 15, 20, 45", "1, 5, 9, 15, 25, 45"})
    void 로또_번호가_정상적일때(String lottoNumberText) {
        LottoNumbers lottoNumbers = new LottoNumbers(lottoNumberText);
        assertThat(lottoNumbers).isEqualTo(lottoNumbers);
    }
}
