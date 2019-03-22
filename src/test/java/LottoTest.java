import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTest {

    @Test
    public void 당첨번호_매칭확인() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getRank(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)),13)).isEqualTo(Rank.MISS);
        assertThat(lotto.getRank(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)),13)).isEqualTo(Rank.THIRD);
        assertThat(lotto.getRank(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)),1)).isEqualTo(Rank.SECOND);
        assertThat(lotto.getRank(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)),8)).isEqualTo(Rank.FIRST);
    }
}