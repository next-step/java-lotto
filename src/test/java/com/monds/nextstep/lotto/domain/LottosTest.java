package com.monds.nextstep.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottosTest {

    @Test
    @DisplayName("로또 생성: 자동")
    void testCreateLottosAuto() {
        // given
        int money = 1000;
        // when
        Lottos lottos = new Lottos.Builder(money)
                .build();
        // then
        assertLottos(lottos, 1, 0);
    }

    @Test
    @DisplayName("로또 생성: 수동")
    void testCreateLottosManual() {
        // given
        int money = 1000;
        // when
        Lottos lottos = new Lottos.Builder(money)
                .ifBuyManual(1, count -> Collections.singletonList(Lotto.of("1,2,3,4,5,6")))
                .build();
        // then
        assertLottos(lottos, 0, 1);
    }

    @Test
    @DisplayName("로또 생성: 자동 + 수동")
    void testCreateLottosAutoWithManual() {
        // given
        int money = 2000;
        // when
        Lottos lottos = new Lottos.Builder(money)
                .ifBuyManual(1, count -> Collections.singletonList(Lotto.of("1,2,3,4,5,6")))
                .build();
        // then
        assertLottos(lottos, 1, 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1000})
    @DisplayName("로또 금액이 0이거나 0보다 적은 경우 예외")
    void testInvalidPurchaseMoney(int money) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lottos.Builder(money));
    }

    @Test
    @DisplayName("로또 금액이 1000원 단위가 아닐 경우 예외")
    void testPurchaseLottoWithoutUnit() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lottos.Builder(500));
    }

    @Test
    @DisplayName("로또 수동 생성 개수가 0보다 작은 경우 예외")
    void testInvalidManualCount() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lottos.Builder(1000)
                .ifBuyManual(-10, value -> Collections.emptyList()));
    }

    @Test
    @DisplayName("실제 돈보다 더 많은 수동 개수를 구매한 경우 예외")
    void testNotEnoughMoney() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Lottos.Builder(1000)
                .ifBuyManual(10, value -> Collections.emptyList()));
    }

    void assertLottos(Lottos lottos, int autoCount, int manualCount) {
        assertThat(lottos.getAutoCount()).isEqualTo(autoCount);
        assertThat(lottos.getManualCount()).isEqualTo(manualCount);
    }
}
