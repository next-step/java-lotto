package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    @Test
    void 로또생성() {
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto).isEqualTo(Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void 로또번호개수_예외처리() {
        assertThatThrownBy(() -> {
            Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호중복_예외처리() {
        assertThatThrownBy(() -> {
            Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 5));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호일치숫자() {
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = Lotto.of(winningNumbers);
        Lotto compareLotto = Lotto.of(winningNumbers);

        assertThat(lotto.numberOfSame(compareLotto)).isEqualTo(6);
    }
}