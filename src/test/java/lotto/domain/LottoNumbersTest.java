package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {

    private LottoNumbers lottoNumbers = LottoNumbers.newInstance(Arrays.asList(1, 2, 3, 4, 5, 6));

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
        assertThat(lottoNumbers).isNotNull();
    }

    @DisplayName("로또 번호를 출력할 수 있다.")
    @Test
    void canPrintLottoNumbersToString() {
        assertThat(lottoNumbers.toString())
                .isEqualTo("[1, 2, 3, 4, 5, 6]");
    }

    @DisplayName("다른 로또 번호와 일치하는 번호 개수를 구할 수 있다.")
    @Test
    void canGetMatchCountOtherLottoNumbers() {
        assertThat(lottoNumbers.getMatchCount(LottoNumbers.newInstance(Arrays.asList(1, 2, 9, 4, 11, 26))))
                .isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource(value = { "1,true", "2,true", "3,true", "7,false" })
    void canContainsNumber(int number, boolean result) {
        assertThat(lottoNumbers.isMatchNumber(number)).isEqualTo(result);
    }
}
