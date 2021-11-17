package step2;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class LottoNumbersTest {

    @Test
    void lottoNumbers() {
        LottoNumbers first = new LottoNumbers();
        LottoNumbers second = new LottoNumbers();
        assertNotEquals(first, second);
    }

    @Test
    void equalsAndHashCode() {
        LottoNumbers first = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5));
        LottoNumbers firstSame = new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5));
        LottoNumbers second = new LottoNumbers(Arrays.asList(2, 3, 4, 5, 6));

        assertAll(
            () -> assertEquals(first, firstSame),
            () -> assertEquals(first.hashCode(), firstSame.hashCode()),
            () -> assertNotEquals(first, second),
            () -> assertNotEquals(first.hashCode(), second.hashCode())
        );
    }
}
