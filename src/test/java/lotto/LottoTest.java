package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("로또 1장당 [1-45] 사이 6개 숫자가 랜덤으로 발급 된다.")
    void testCreateLotto() {
        Lotto lotto = new Lotto();
        assertThat(lotto.create()).hasSize(6);

        lotto = new Lotto(1L);
        assertThat(lotto.create()).hasSize(6).containsExactly(16, 29, 38, 34, 45, 5);
        ;

        lotto = new Lotto(2L);
        assertThat(lotto.create()).hasSize(6).containsExactly(14, 43, 21, 38, 25, 16);
    }
}
