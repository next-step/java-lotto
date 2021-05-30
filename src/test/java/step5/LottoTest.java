package step5;

import org.junit.jupiter.api.Test;
import step5.domain.Lotto;
import step5.exception.DuplicatedNumberException;
import step5.exception.InValidLottoNumberException;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

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
    void invalid_범위_밖의_값() {
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 46));
        }).isInstanceOf(InValidLottoNumberException.class);
    }

    @Test
    void invalid_6개의_값이_아닌_경우() {
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5));
        }).isInstanceOf(DuplicatedNumberException.class);
    }

    @Test
    void invalid_중복값이_있는_경우() {
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1, 2, 3, 4, 5, 5));
        }).isInstanceOf(DuplicatedNumberException.class);
    }
}