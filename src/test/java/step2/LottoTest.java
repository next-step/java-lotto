package step2;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    void isWinning() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5));
        assertAll(
            () -> assertTrue(lotto.isWinner(new Lotto(Arrays.asList(1, 2, 3, 4, 5)))),
            () -> assertFalse(lotto.isWinner(new Lotto(Arrays.asList(2, 3, 4, 5, 6))))
        );
    }
}