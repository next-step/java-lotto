package lotto.domain;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @Test
    public void createTest() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(1,2,3,4,5,6)));
    }

    @Test
    public void exceedLottoNumberCountTest() {
        assertThatThrownBy(
                () -> new Lotto(Arrays.asList(1,2,3,4,5))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void duplicateCheck() {
        assertThatThrownBy(
                () -> new Lotto(Arrays.asList(1,2,3,4,5,5))
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void matchTest() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        int count = lotto.match(winningLotto);
        assertThat(count).isEqualTo(6);
    }

    @Test
    public void lottoRangeTest() {
        assertThatThrownBy(
                () -> new Lotto(Arrays.asList(1,2,33,44,55,6))
        ).isInstanceOf(IllegalArgumentException.class);
    }

}