package lotto;

import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    @DisplayName("입력된 갯수의 로또가 생성되는지 확인")
    void testIfGenerateLottos(){
        Lottos lottos = new Lottos(14);

        assertThat(lottos.getLottos()).hasSize(14);
    }
}
