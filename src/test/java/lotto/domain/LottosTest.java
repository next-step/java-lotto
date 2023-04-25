package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {

    @Test
    @DisplayName("Lottos 를 생성한다.")
    void test01() {
        Lottos lottos = new Lottos(1000);

        assertThat(lottos).isNotNull();
    }

    @Test
    @DisplayName("구입금액으로 Lottos 를 생성한다.")
    void test02() {
        Lottos lottos = new Lottos(10100);

        assertThat(lottos.lottos()).hasSize(10);
    }

    @Test
    @DisplayName("구입금액이 천원보다 적으면 에러를 발생한다.")
    void test03() {
        assertThatThrownBy(() -> new Lottos(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 확인을 한다.")
    void test04() {
        Lottos lottos = new Lottos(new Lotto(1, 2, 3, 4, 5, 6), new Lotto(1, 2, 3, 4, 5, 45));

        List<WinType> winTypes = lottos.confirmWins(new WinNumbers(1, 2, 3, 4, 5, 6));

        assertThat(winTypes).containsExactly(WinType.FIRST, WinType.THIRD);
    }
}
