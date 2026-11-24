package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 5, 7})
    void 숫자가_6개가_아니면_예외가_발생한다(int size) {
        List<Integer> numbers = IntStream.rangeClosed(1, size).boxed().toList();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(numbers));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 범위를_벗어난_숫자가_있으면_예외가_발생한다(int outOfRangeNumber) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, outOfRangeNumber);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(numbers));
    }

    @Test
    void 중복된_숫자가_있으면_예외가_발생한다() {
        List<Integer> numbers = List.of(1, 1, 2, 3, 4, 5);

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(numbers));
    }

    @Test
    void 숫자들을_오름차순으로_정렬해서_가진다() {
        Lotto lotto = new Lotto(List.of(45, 3, 21, 8, 1, 30));

        assertThat(lotto.getNumbers()).containsExactly(1, 3, 8, 21, 30, 45);
    }

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            "7, 8, 9, 10, 11, 12 | 0",
            "1, 2, 3, 10, 11, 12 | 3",
            "6, 5, 4, 3, 2, 1    | 6"
    })
    void 다른_로또와_일치하는_숫자의_개수를_반환한다(String otherNumbers, int expected) {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto other = new Lotto(toNumbers(otherNumbers));

        assertThat(lotto.countMatches(other)).isEqualTo(expected);
    }

    private List<Integer> toNumbers(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }
}
