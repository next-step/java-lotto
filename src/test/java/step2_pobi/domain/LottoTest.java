package step2_pobi.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    void match() {
        Lotto userLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int matchCount = userLotto.match(winningLotto);
        assertThat(matchCount).isEqualTo(6);
    }

    @Test
    void create() {
        List<Integer> lotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(new Lotto(lotto)).isEqualTo(new Lotto(lotto));
    }

    @Test
    @DisplayName("6개의 값이 아닌 경우")
    void invalid1() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복값이 있는 경우")
    void invalid2() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("범위 밖의 값이 있는 경우")
    void invalid3() {
        assertThatThrownBy(() -> new Lotto(Arrays.asList(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
