package net.chandol.lotto.domain;

import org.junit.Test;

import static net.chandol.lotto.domain.LottoNumber.direct;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test(expected = IllegalArgumentException.class)
    public void Null유효성_확인() {
        new Lotto(null);
    }

    @Test
    public void getMatchCount() {
        Lotto lotto = new Lotto(direct(1, 2, 3, 4, 5, 6));
        int matchCount = lotto.getMatchCount(direct(4, 5, 6, 7, 8, 9));
        assertThat(matchCount).isEqualTo(3);
    }
}