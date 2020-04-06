package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    private Lotto lotto;

    @Test
    public void createOneLotto() {
        lotto = new Lotto();
        Set<Integer> numbers = lotto.getLottoNumbers();
        assertThat(numbers).hasSize(6);
    }

    @Test
    public void createWinningLotto() {
        Lotto winningLotto = new Lotto(1, 3, 2, 4, 5, 6);
        Set<Integer> winningNumbers = winningLotto.getLottoNumbers();
        assertThat(winningNumbers).hasSize(6).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void createLottoWithInsufficientInputThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lotto = new Lotto(1, 2, 3);
        }).withMessage("로또 번호는 6개만 가능합니다.");
    }

    @Test
    public void createLottoWithOverFlowInputThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lotto = new Lotto(1, 2, 3, 4, 5, 6, 7, 8, 9);
        }).withMessage("로또 번호는 6개만 가능합니다.");
    }
}
