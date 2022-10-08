package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void 로또번호_서로다른_6개숫자() {
        List<Integer> lottoNumbers = new Lotto().getRandomNumbers();
        Set<Integer> lottoSet = new HashSet<>(lottoNumbers);
        assertThat(lottoSet).hasSize(6);
    }

    @Test
    public void 로또_일치하는_번호_6개() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winning = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(lotto.getSameNumbers(winning)).isEqualTo(6);
    }

    @Test
    public void 로또_일치하는_번호_5개() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winning = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10));
        assertThat(lotto.getSameNumbers(winning)).isEqualTo(5);
    }

    @Test
    public void 로또_일치하는_번호_4개() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winning = new Lotto(Arrays.asList(1, 2, 3, 44, 5, 10));
        assertThat(lotto.getSameNumbers(winning)).isEqualTo(4);
    }

    @Test
    public void 로또_일치하는_번호_3개() {
        Lotto lotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winning = new Lotto(Arrays.asList(1, 2, 3, 44, 45, 10));
        assertThat(lotto.getSameNumbers(winning)).isEqualTo(3);
    }

    @Test
    public void 문자열_로또클래스_변환() {
        Lotto lotto = new Lotto("1, 2, 3, 4, 5, 6");
        assertThat(lotto.isEqual(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)))).isTrue();
    }
}
