package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottosTest {
    @Test
    @DisplayName("주어진 금액만큼 구매 가능한 개수의 Lotto를 생성하여 리스트에 추가한다.")
    void 로또구매() {
        Lottos lottos = new Lottos(10000);
        assertThat(lottos.count()).isEqualTo(10);
    }
}
