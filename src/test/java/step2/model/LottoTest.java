package step2.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step2.model.Lotto;

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
    void getMatchCount() {
        Lotto firstRank = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto secondRank = new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7));
        Lotto thirdRank = new Lotto(Arrays.asList(3, 4, 5, 6, 7, 8));
        Lotto fourthRank = new Lotto(Arrays.asList(4, 5, 6, 7, 8, 9));

        assertAll(
            () -> assertEquals(6, lotto.getMatchCount(firstRank)),
            () -> assertEquals(5, lotto.getMatchCount(secondRank)),
            () -> assertEquals(4, lotto.getMatchCount(thirdRank)),
            () -> assertEquals(3, lotto.getMatchCount(fourthRank))
        );
    }
}
