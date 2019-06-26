package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @Test
    public void match_1등() {
        Lotto userLotto = Lotto.of(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = Lotto.of(1, 2, 3, 4, 5, 6);
        int result = userLotto.match(winningLotto);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void match_3등() {
        Lotto userLotto = Lotto.of(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = Lotto.of(1, 2, 3, 4, 5, 7);

        int result = userLotto.match(winningLotto);

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void of_문자열_숫자() {
        Lotto lotto = Lotto.ofComma("1, 2, 3, 4, 5, 6");
        assertThat(lotto).isEqualTo(Lotto.of(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void of_Set() {
        Set<Integer> lotto = new HashSet(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(Lotto.of(lotto)).isEqualTo(Lotto.ofComma("1,2,3,4,5,6"));
    }

    @Test
    public void of_중복_값() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lotto.ofComma("1, 2, 3, 4, 5, 5");
        });
    }

    @Test
    public void of_6개_미만의_값() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lotto.ofComma("1, 2, 3, 4, 5");
        });
    }

    @Test
    public void of_문자열_isNull() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lotto.ofComma("1, 2, 3, 4, 5, 5");
        });
    }
}
