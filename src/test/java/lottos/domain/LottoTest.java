package lottos.domain;

import lottos.domain.exceptions.LottoNumberRangeIncorrectException;
import lottos.domain.exceptions.LottoSizeIncorrectException;
import lottos.domain.numbers.Number;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    private LottoGenerator generator = new LottoRandomGenerator();

    @ParameterizedTest
    @NullAndEmptySource
    @CsvSource(value = {"1,2,3,4,5", "1,2,3,4,5,6,7"}, delimiter = ':')
    void 로또넘버가_여섯개가_아닌_로또면_에러(final String numbersText) {
        assertThrows(LottoSizeIncorrectException.class, () -> new Lotto(numbersText));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,70", "1,2,3,4,50,6"}, delimiter = ':')
    void 로또의_숫자_범위가_아닐경우_에러(final String numbersText) {
        assertThrows(LottoNumberRangeIncorrectException.class, () -> new Lotto(numbersText));
    }

    @Test
    void 로또_랜덤_생성() {
        List<Integer> randoms = generator.generate();

        final List<Integer> numbers = randoms.subList(0, 6);

        Lotto lotto = new Lotto(numbers);
        assertEquals(lotto.getNumbers().elements().size(), 6);
        for (Number number : lotto.getNumbers().elements()) {
            assertTrue(number.value() >= 1 && number.value() <= 45);
        }
    }
}
