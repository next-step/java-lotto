package lotto.domain;

import lotto.generator.ManualNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 로또_일치하는_번호_6개() {
        Lotto lotto = new Lotto(new ManualNumberGenerator("1, 2, 3, 4, 5, 6"));
        Lotto winning = new Lotto(new ManualNumberGenerator("1, 2, 3, 4, 5, 6"));
        assertThat(lotto.getSameNumberCount(winning)).isEqualTo(6);
    }

    @Test
    public void 로또_일치하는_번호_5개() {
        Lotto lotto = new Lotto(new ManualNumberGenerator("1, 2, 3, 4, 5, 6"));
        Lotto winning = new Lotto(new ManualNumberGenerator("1, 2, 3, 4, 5, 10"));
        assertThat(lotto.getSameNumberCount(winning)).isEqualTo(5);
    }

    @Test
    public void 로또_일치하는_번호_4개() {
        Lotto lotto = new Lotto(new ManualNumberGenerator("1, 2, 3, 4, 5, 6"));
        Lotto winning = new Lotto(new ManualNumberGenerator("1, 2, 3, 44, 5, 10"));
        assertThat(lotto.getSameNumberCount(winning)).isEqualTo(4);
    }

    @Test
    public void 로또_일치하는_번호_3개() {
        Lotto lotto = new Lotto(new ManualNumberGenerator("1, 2, 3, 4, 5, 6"));
        Lotto winning = new Lotto(new ManualNumberGenerator("1, 2, 3, 44, 45, 10"));
        assertThat(lotto.getSameNumberCount(winning)).isEqualTo(3);
    }
}
