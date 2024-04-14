package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    @Test
    @DisplayName("로또를 입력받은 갯수만큼 생성한다")
    void create_lottos() {
        Lottos lottos = new Lottos(5);
        assertEquals(5, lottos.size());
    }

    @Test
    @DisplayName("자동 로또와 수동 로또 리스트를 입력받아 합친다")
    void add_lottos() {
        Lottos manualLottos = new Lottos(1);
        Lottos lottos = new Lottos(5, manualLottos);
        assertEquals(6, lottos.size());
    }

    @Test
    @DisplayName("자동 로또가 0건일 때, 수동 로또 리스트만 생성한다.")
    void add_empty_auto_lottos() {
        Lottos manualLottos = new Lottos(1);
        Lottos lottos = new Lottos(0, manualLottos);
        assertEquals(1, lottos.size());
    }

    @Test
    @DisplayName("수동 로또가 0건일 때, 자동 로또 리스트만 생성한다.")
    void add_empty_manual_lottos() {
        Lottos manualLottos = new Lottos(0);
        Lottos lottos = new Lottos(1, manualLottos);
        assertEquals(1, lottos.size());
    }
}
