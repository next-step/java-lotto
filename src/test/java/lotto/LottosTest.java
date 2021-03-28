package lotto;

import lotto.domain.Lottos;
import lotto.domain.NumbersGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
public class LottosTest {
    @DisplayName("Lotto를 구입한 가격만큼 Lotto 갯수 확인")
    @Test
    void lottos() {
        // GIVE
        int payLotto = 14000;
        Lottos lottos;
        // WHEN
        lottos = new Lottos(payLotto, new NumbersGenerator());
        // THEN
        assertThat(lottos.getLottos().size()).isEqualTo(14);

    }
}
