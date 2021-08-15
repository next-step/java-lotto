package lottos.controller;

import lottos.domain.exceptions.LottoSizeIncorrectException;
import lottos.domain.numbers.Numbers;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoConsoleControllerTest {

    private final LottoConsoleController consoleController = new LottoConsoleController(size -> Numbers.valueOf(Arrays.asList(1, 2, 3, 4, 5, 6)));

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:7,8", "1,2,3,4,5,6:7,8,9"}, delimiter = ':')
    void 보너스_넘버가_여러개인_로또면_에러(final String numbersText, final String bonusText) {
        assertThrows(NumberFormatException.class, () -> consoleController.lastWeeksWinningLotto(numbersText, bonusText));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6,7:8", "1,2,3,4,5:7", ":5"}, delimiter = ':')
    void 로또_개수가_올바르지_않을경우(final String numbersText, final String bonusText) {
        assertThrows(LottoSizeIncorrectException.class, () -> consoleController.lastWeeksWinningLotto(numbersText, bonusText));
    }
}