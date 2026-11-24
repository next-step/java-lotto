package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
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
}
