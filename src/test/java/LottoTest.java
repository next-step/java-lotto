import domain.Lotto;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class LottoTest {
    @Test
    public void 랜덤으로_번호를_부여받기() {
        Lotto lotto = new Lotto();

        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @Test
    public void 번호를_지정하여_로또를_생성() {
        Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);

        assertThat(lotto.getNumbers().contains(1)).isTrue();
        assertThat(lotto.getNumbers().contains(2)).isTrue();
        assertThat(lotto.getNumbers().contains(3)).isTrue();
        assertThat(lotto.getNumbers().contains(4)).isTrue();
        assertThat(lotto.getNumbers().contains(5)).isTrue();
        assertThat(lotto.getNumbers().contains(6)).isTrue();
    }
}