package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @ValueSource(ints = { 1, 2, 3, 4, 5, 6, 7 })
    void canContainsMatchNumber(int lottoNumber) {
        assertThat(this.lottoNumbers.isMatchNumber(lottoNumber)).isEqualTo(lottoNumber <= 6);
    }
}
