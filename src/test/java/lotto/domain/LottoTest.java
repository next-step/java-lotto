package lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void publish() {
        Lotto lotto = new Lotto();

        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();

        assertThat(new HashSet<>(lottoNumbers).size()).isEqualTo(Lotto.LOTTO_SIZE);
    }

    @Test
    public void getContainsCount() {
        final Lotto winningLotto = new Lotto(Arrays.asList(
                new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

        final Lotto lotto = new Lotto(Arrays.asList(
                new LottoNumber(11), new LottoNumber(12), new LottoNumber(10),
                new LottoNumber(16), new LottoNumber(5), new LottoNumber(6)));

        final int containsCount = lotto.getContainsCount(winningLotto);

        assertThat(containsCount).isEqualTo(2);
    }
}
