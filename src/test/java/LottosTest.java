import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("입력받은 로또 구입 금액만큼 로또를 발급한다.")
    @Test
    void test01() {
        // given
        int price = 14000;

        // when
        Lottos lottos = new Lottos(price);

        // then
        assertThat(lottos.getLottoCount()).isEqualTo(14);
    }
}
