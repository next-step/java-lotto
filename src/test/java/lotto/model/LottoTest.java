package lotto.model;

import org.junit.Test;

import java.util.Arrays;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoTest {

    @Test
    public void 생성() {
        assertThat(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    public void 생성_콤마() {
        assertThat(Lotto.fromComma("1,2,3,4,5,6")).isEqualTo(Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 생성_6개_외() {
        Lotto.from(Arrays.asList(1, 2, 3, 4, 5));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 생성_중복() {
        Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 5));
    }

    @Test
    public void 일치하는_숫자_개수() {
        Lotto lotto = Lotto.from(Arrays.asList(1, 2, 3, 4, 5, 6));
        System.out.println(lotto);
        assertThat(lotto.getMatchCount(Lotto.from(Arrays.asList(1, 2, 3, 10, 20, 30)))).isEqualTo(3);
    }
}
