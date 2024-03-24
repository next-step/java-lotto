package lotto;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    void 몇개_맞았는지_계산해주기() {
        Lotto winLotto = new Lotto(Set.of(1, 2, 3, 4, 5, 6));
        Lotto myLotto = new Lotto(Set.of(1, 2, 3, 7, 8, 9));
        MatchedCount count = winLotto.countMatchedNumber(myLotto);

        assertThat(count).isEqualTo(new MatchedCount(3));
    }
}