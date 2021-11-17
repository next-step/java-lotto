package step2;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void init() {
        lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    void lotto() {
        Lotto lotto = new Lotto();
        Lotto custom = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    void getRank() {
        Lotto firstRank = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto secondRank = new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7));
        Lotto thirdRank = new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8));
        Lotto fourthRank = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));

        assertAll(
            () -> assertEquals(1, lotto.getMatchCount(firstRank)),
            () -> assertEquals(2, lotto.getMatchCount(secondRank)),
            () -> assertEquals(3, lotto.getMatchCount(thirdRank)),
            () -> assertEquals(4, lotto.getMatchCount(fourthRank))
        );
    }
}
