package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
        Lotto lotto = new Lotto();
        Set<Integer> lottoNumbers = new HashSet<>(lotto.getLottoNumbers());

        List<Integer> winningNumbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        int containsCount = lotto.getContainsCount(winningNumbers);
        lottoNumbers.retainAll(winningNumbers);

        assertThat(containsCount).isEqualTo(lottoNumbers.size());
    }
}
