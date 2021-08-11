package lottos.domain;

import lottos.domain.exceptions.LottoNumberRangeIncorrectException;
import lottos.domain.exceptions.LottoSizeIncorrectException;
import lottos.domain.numbers.Number;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {


    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5", "1,2,3,4,5,6,7"}, delimiter = ':')
    void 로또넘버가_여섯개가_아닌_로또면_에러(final String input) {
        List<Integer> numbers = getNumbers(input);

        assertThrows(LottoSizeIncorrectException.class, () -> new Lotto(numbers));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,70", "1,2,3,4,50,6"}, delimiter = ':')
    void 로또의_숫자_범위가_아닐경우_에러(final String input) {
        List<Integer> numbers = getNumbers(input);

        assertThrows(LottoNumberRangeIncorrectException.class, () -> new Lotto(numbers));
    }

    @Test
    void 로또_개수_검증() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Lotto lotto = new Lotto(numbers);

        assertEquals(lotto.getNumbers().elements().size(), numbers.size());
    }

    @Test
    void 로또_범위_검증() {

        // given
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        numbers.sort(null);
        final int min = numbers.get(0);
        final int max = numbers.get(numbers.size() - 1);

        // when
        Lotto lotto = new Lotto(numbers);

        // then
        for (Number number : lotto.getNumbers().elements()) {
            assertTrue(number.value() >= min && number.value() <= max);
        }
    }

    private List<Integer> getNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
