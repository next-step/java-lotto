package vo;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTest {
    @Test
    public void of_문자열_숫자() {
        Lotto lotto = Lotto.ofComma("1, 2, 3, 4, 5, 6");
        assertThat(lotto).isEqualTo(Lotto.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void of_Set() {
        HashSet lotto = new HashSet(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(Lotto.of(lotto)).isEqualTo(Lotto.ofComma("1,2,3,4,5,6"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void of_중복_값() {
        Lotto.ofComma("1, 2, 3, 4, 5, 5");
    }

    @Test(expected = IllegalArgumentException.class)
    public void of_문자열_isNull() {
        Lotto.ofComma("");
    }

    @Test
    public void match() {
        Lotto userLotto = Lotto.ofComma("1, 2, 3, 4, 5, 6");
        Lotto winningLotto = Lotto.ofComma("1, 2, 3, 4, 5, 6");
        assertThat(userLotto.match(winningLotto)).isEqualTo(6);
    }
}