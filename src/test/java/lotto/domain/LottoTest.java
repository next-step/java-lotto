package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    void countMatching() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        Lotto match3 = new Lotto(1, 2, 3, 40, 41, 42);

        assertThat(lotto.countMatching(match3, new LottoNumber(7))).isEqualTo(Rank.FIFTH);
    }
}
