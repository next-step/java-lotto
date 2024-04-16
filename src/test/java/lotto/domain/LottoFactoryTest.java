package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoFactoryTest {

    @Test
    @DisplayName("자동 로또만 입력 시, 자동 로또를 금액만큼 생성한다")
    void create_auto_Lottos() {
        // given
        int money = 1000;
        int expected = 1;

        // when
        Lottos lottos = LottoFactory.createLottos(money);

        // then
        assertEquals(expected, lottos.of().size());
    }

    @Test
    @DisplayName("수동 로또만 입력 시, 수동 로또를 금액만큼 생성한다")
    void create_manual_Lottos() {
        // given
        int money = 1000;
        int expected = 1;

        // when
        Lottos lottos = LottoFactory.createLottos(money, 1, new Lottos(1));

        // then
        assertEquals(expected, lottos.of().size());
    }

    @Test
    @DisplayName("수동 로또와 자동 로또 모두 입력시, 로또를 금액만큼 생성한다")
    void create_all_Lottos() {
        // given
        int money = 9999;
        int manualLottoCount = 3;
        int expected = 9;

        // when
        Lottos lottos = LottoFactory.createLottos(money, manualLottoCount, new Lottos(manualLottoCount));

        // then
        assertEquals(expected, lottos.of().size());
    }

    @Test
    @DisplayName("1000원보다 구매 금액이 부족하면 에러가 난다")
    void create_Lottos_cost_exception() {
        // given
        int money = 999;

        // when & then
        assertThrows(IllegalArgumentException.class, () -> LottoFactory.createLottos(money));
    }

    @Test
    @DisplayName("수동 로또 장수가 로또 구매가능한 금액보다 부족하면 에러가 난다")
    void create_manual_Lottos_cost_exception() {
        // given
        int money = 1000;

        // when & then
        assertThrows(IllegalArgumentException.class, () -> LottoFactory.createLottos(money, 2, new Lottos(2)));
    }

}
