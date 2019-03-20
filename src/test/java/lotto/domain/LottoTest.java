package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import org.junit.Test;

public class LottoTest {

    @Test
    public void publish() {
        Lotto lotto = new Lotto();

        List<Integer> lottoNumbers = lotto.getLottoNumbers();

        assertThat(new HashSet<>(lottoNumbers).size()).isEqualTo(Lotto.LOTTO_SIZE);
    }

    @Test
    public void getContainsCount() {
        Lotto lotto = new Lotto(Arrays.asList(1, 12, 13, 14, 15, 16));
        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        final int containsCount = lotto.getContainsCount(winningLotto);

        assertThat(containsCount).isEqualTo(1);
    }
}
