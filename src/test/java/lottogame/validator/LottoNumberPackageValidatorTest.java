package lottogame.validator;

import lottogame.domain.LottoNumber;
import org.junit.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lottogame.domain.LottoNumberPackage.LOTTO_GAME_SIZE;
import static org.junit.Assert.*;

public class LottoNumberPackageValidatorTest {

    private LottoNumberPackageValidator validator = new LottoNumberPackageValidator();

    @Test
    public void isValid_for_null() {
        assertFalse(validator.isValid(null));
    }

    @Test
    public void isValid_for_less_than_LOTTO_GAME_SIZE() {
        assertFalse(validator.isValid(getRangedNumbers(1, LOTTO_GAME_SIZE-1)));
    }

    @Test
    public void isValid_for_LOTTO_GAME_SIZE() {
        assertTrue(validator.isValid(getRangedNumbers(1, LOTTO_GAME_SIZE)));
    }

    @Test
    public void isValid_for_more_than_LOTTO_GAME_SIZE() {
        assertFalse(validator.isValid(getRangedNumbers(1, LOTTO_GAME_SIZE+1)));
    }

    private Set<LottoNumber> getRangedNumbers(int from, int to) {
        return IntStream.rangeClosed(from, to)
                .boxed()
                .map(LottoNumber::getInstance)
                .collect(Collectors.toSet());
    }
}