package lotto;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class WiningLottoTest {

    @Test
    void count_matched_number() {
        Lotto lotto = new Lotto(Set.of(1, 2, 11, 14, 16, 34));
        WiningLotto winingLotto = new WiningLotto(Set.of(1, 14, 22, 24, 34, 44), 11);

        MatchedCount matchedCount = winingLotto.countMatchedNumber(lotto);
        assertThat(matchedCount).isEqualTo(new MatchedCount(3));
    }

    @Test
    void count_matched_number_with_bonus() {
        Lotto lotto = new Lotto(Set.of(1, 14, 22, 24, 34, 11));
        WiningLotto winingLotto = new WiningLotto(Set.of(1, 14, 22, 24, 34, 44), 11);

        MatchedCount matchedCount = winingLotto.countMatchedNumber(lotto);
        assertThat(matchedCount).isEqualTo(new MatchedCount(5, true));
    }
}