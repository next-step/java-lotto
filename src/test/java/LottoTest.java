import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTest {

    @Test
    public void 당첨번호_매칭확인() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getMatchNumber(new Lotto(Arrays.asList(7, 8, 9, 10, 11, 12)))).isEqualTo(0);
        assertThat(lotto.getMatchNumber(new Lotto(Arrays.asList(6, 7, 8, 9, 10, 11)))).isEqualTo(1);
        assertThat(lotto.getMatchNumber(new Lotto(Arrays.asList(5, 6, 7, 8, 9, 10, 11)))).isEqualTo(2);
        assertThat(lotto.getMatchNumber(new Lotto(Arrays.asList(2, 3, 4, 5, 6, 7)))).isEqualTo(5);
        assertThat(lotto.getMatchNumber(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))).isEqualTo(6);
    }
}