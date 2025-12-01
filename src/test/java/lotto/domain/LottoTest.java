package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    @Test
    public void match_1등() {
        Lotto userLotto = new Lotto(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 6);
        int result = userLotto.match(winningLotto);
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void match_3등() {
        Lotto userLotto = new Lotto(1, 2, 3, 4, 5, 6);
        Lotto winningLotto = new Lotto(1, 2, 3, 4, 5, 7);

        int result = userLotto.match(winningLotto);

        assertThat(result).isEqualTo(5);
    }

    @Test
    public void create() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);
        assertThat(lotto).isEqualTo(new Lotto("1,2,3,4,5,6"));
        assertThat(lotto).isEqualTo(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
    }

    @Test
    public void 중복_값() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto("1, 2, 3, 4, 5, 5");
        });
    }

    @Test
    public void 크기6_미만의_값() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto("1, 2, 3, 4, 5");
        });
    }
}