package autoLotto;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LottoValidatorTest {

    private LottoValidator lottoValidator = new LottoValidator();

    @Test
    void valid() {
        Set<Integer> lotto = Set.of(1,2,3,4,5,6);
        assertDoesNotThrow(() -> lottoValidator.validateInputLotto(lotto));
    }

    @Test
    void invalid() {
        Set<Integer> lotto = Set.of(1,2,3,4,5);
        assertThrows(IllegalArgumentException.class, () -> lottoValidator.validateInputLotto(lotto));
    }
}
