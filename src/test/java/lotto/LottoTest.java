package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRandomGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("로또 1장당 [1-45] 사이 6개 숫자가 랜덤으로 발급 된다.")
    void testCreateLotto() {
        Lotto lotto = new Lotto();
        assertThat(lotto.getNumbers().getNumbers()).hasSize(6);

        lotto = new Lotto(new LottoRandomGenerator(1L));
        assertThat(lotto.getNumbers().getNumbers().stream().sorted()).hasSize(6)
                .containsExactly(
                        new LottoNumber(5),
                        new LottoNumber(16),
                        new LottoNumber(29),
                        new LottoNumber(34),
                        new LottoNumber(38),
                        new LottoNumber(45));

        lotto = new Lotto(new LottoRandomGenerator(2L));
        assertThat(lotto.getNumbers().getNumbers().stream().sorted()).hasSize(6).containsExactly(
                new LottoNumber(14),
                new LottoNumber(16),
                new LottoNumber(21),
                new LottoNumber(25),
                new LottoNumber(38),
                new LottoNumber(43)
        );
    }
}
