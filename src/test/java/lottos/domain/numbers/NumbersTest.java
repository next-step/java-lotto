package lottos.domain.numbers;

import lottos.domain.exceptions.LottoSizeIncorrectException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;


class NumbersTest {

    @Test
    void 로또_번호는_6개가_아니면_오류() {
        assertThrows(LottoSizeIncorrectException.class, () -> Numbers.valueOf(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    void 로또_번호는_6개면_정상_생성() {
        assertDoesNotThrow(() -> Numbers.valueOf(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,10:1,2,3,4,7,8:4", "10,11,12,13,14,15:15,16,17,18,19,20:1"}, delimiter = ':')
    void 매치수_검증(final String numberText1, final String numberText2, final String expect) {
        Numbers numbers1 = Numbers.valueOf(getNumbers(numberText1));
        Numbers numbers2 = Numbers.valueOf(getNumbers(numberText2));

        int actual = numbers1.match(numbers2);
        assertEquals(actual, Integer.parseInt(expect));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,10:1,2,3,4,5,10:true", "10,11,12,13,14,15:10,11,12,13,14,16:false"}, delimiter = ':')
    void Numbers_동등성_비교(final String numberText1, final String numberText2, final boolean actual) {
        Numbers numbers1 = Numbers.valueOf(getNumbers(numberText1));
        Numbers numbers2 = Numbers.valueOf(getNumbers(numberText2));
        assertEquals(numbers1.equals(numbers2), actual);
    }

    private List<Integer> getNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
