package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    public void createOneLotto() {
        Lotto lotto = new Lotto();
        Set<Integer> numbers = lotto.getLottoNumbers();
        assertThat(numbers).hasSize(6);
    }

    @Test
    public void createWinningLotto() {
        Lotto winningLotto = new Lotto(1, 3, 2, 4, 5, 6);
        Set<Integer> winningNumbers = winningLotto.getLottoNumbers();
        assertThat(winningNumbers).hasSize(6).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
