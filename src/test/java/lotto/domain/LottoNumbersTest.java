package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

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
    @ParameterizedTest
    @MethodSource("generateNumbers")
    void canNotCreateLottoNumbersIfUnless6LottoNumbers(List<Integer> numbers) {
        assertThatThrownBy(() -> LottoNumbers.newInstance(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> generateNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
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
        LottoNumbers lotto = LottoNumbers.newInstance(Arrays.asList(1, 2, 9, 4, 11, 26));
        assertThat(lottoNumbers.getMatchCount(lotto)).isEqualTo(3);
    }

    @DisplayName("중복되지 않은 숫자를 생성할 수 있다.")
    @Test
    void canCreateNonDuplicateNumbers() {
        List<Integer> nonDuplicateNumbers = LottoNumbers.createNonDuplicateNumbers();

        assertThat(nonDuplicateNumbers).isNotNull();
        assertThat(nonDuplicateNumbers).hasSize(6);
    }

    @DisplayName("로또 번호에 특정 번호가 포함되어 있는지 알 수 있다.")
    @ParameterizedTest
    @CsvSource(value = { "1,true", "2,true", "3,true", "4,true", "5,true", "6,true", "7,false" })
    void canContainsMatchNumber(int lottoNumber, boolean result) {
        assertThat(this.lottoNumbers.isMatchNumber(lottoNumber)).isEqualTo(result);
    }

    @DisplayName("로또 문자열로 중복되지 않은 숫자를 생성할 수 있다.")
    @Test
    void canCreateManualNonDuplicateNumbers() {
        List<Integer> nonDuplicateNumbers = LottoNumbers.createNonDuplicateNumbers("1, 2, 3, 4, 5, 6");

        assertThat(nonDuplicateNumbers).isNotNull();
        assertThat(nonDuplicateNumbers).hasSize(6);
    }

    @DisplayName("객체를 복사할 수 있다.")
    @Test
    void canClone() {
        LottoNumbers clonedLottoNumbers = this.lottoNumbers.clone();
        assertThat(this.lottoNumbers).isNotEqualTo(clonedLottoNumbers);
    }
}
