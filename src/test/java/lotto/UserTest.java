package lotto;

import org.junit.jupiter.api.Test;
import lotto.domain.AutoLottoMatchCount;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UserTest {
    @Test
    void 로또_3개_일치_2번() {
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto first = new Lotto(Arrays.asList(14, 13, 15, 12, 16, 11));
        Lotto second = new Lotto(Arrays.asList(24, 3, 5, 2, 26, 21));
        Lotto three = new Lotto(Arrays.asList(34, 33, 35, 3, 6, 1));

        List<Lotto> lottoList = Arrays.asList(first, second, three);
        AutoLottoMatchCount autoLottoMatchCount = new AutoLottoMatchCount();
        for (Lotto lotto : lottoList) {
            autoLottoMatchCount.lottoCountPlus((winningLotto.winningLottoCount(lotto)));
        }

        assertThat(autoLottoMatchCount.findLottoNumberCount(3)).isEqualTo(2);
    }
}
