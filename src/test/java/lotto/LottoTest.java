package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("로또 1장당 [1-45] 사이 6개 숫자가 랜덤으로 발급 된다.")
    void testCreateLotto() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getNumbers()).hasSize(6);

        lotto = new Lotto(new LottoRandomGenerator(1L));
        assertThat(lotto.getNumbers().stream().sorted()).hasSize(6).containsExactly(5, 16, 29, 34, 38, 45);
        ;

        lotto = new Lotto(new LottoRandomGenerator(2L));
        assertThat(lotto.getNumbers().stream().sorted()).hasSize(6).containsExactly(14, 16, 21, 25, 38, 43);
    }

    @Test
    @DisplayName("발급된 로또를 1장씩 화면에 출력한다.")
    void testPrintLotto() {
        assertThat(new Lotto(new LottoRandomGenerator(1L)).toString()).isEqualTo("[5, 16, 29, 34, 38, 45]");
        assertThat(new Lotto(new LottoRandomGenerator(2L)).toString()).isEqualTo("[14, 16, 21, 25, 38, 43]");
    }
}
