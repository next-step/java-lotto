package lottos.domain.numbers;

import lottos.domain.exceptions.LottoSizeIncorrectException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


class NumbersTest {

    @Test
    @DisplayName("로또 번호는 6개가 아니면 오류")
    void size_incorrect_exception() {
        Assertions.assertThrows(LottoSizeIncorrectException.class, () -> Numbers.from(Arrays.asList(1, 2, 3, 4, 5)));
    }

    @Test
    @DisplayName("로또 번호는 6개면 정상 생성")
    void size() {
        Assertions.assertDoesNotThrow(() -> Numbers.from(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,10:1,2,3,4,7,8:4", "10,11,12,13,14,15:15,16,17,18,19,20:1"}, delimiter = ':')
    void 매치수_검증(final String numberText1, final String numberText2, final String expect) {
        Numbers numbers1 = Numbers.from(getNumbers(numberText1));
        Numbers numbers2 = Numbers.from(getNumbers(numberText2));

        int actual = numbers1.match(numbers2);
        Assertions.assertEquals(actual, Integer.parseInt(expect));
    }

    private List<Integer> getNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
