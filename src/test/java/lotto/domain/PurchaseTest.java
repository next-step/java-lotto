package lotto.domain;

import lotto.service.NumberSelectionStrategyImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PurchaseTest {

    private LottoCounter lottoCounter;

    @BeforeEach
    void setUp() {
        lottoCounter = new LottoCounter(10000, 1);
    }

    @Test
    @DisplayName("입력한 구매할 수동 로또 수와 실제 입력한 수동 로또 수가 다를 때")
    void drawLottos_notMatchingManualLottoCount() {
        Purchase purchase = new Purchase(lottoCounter, new Lottos(2, new NumberSelectionStrategyImpl()));

        assertThatThrownBy(() -> {
            purchase.drawLottos();
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("manual lotto count is different with numbers count you input");
    }

    @Test
    @DisplayName("로또 구매")
    void drawLottos() {
        Lotto lotto = new Lotto(Numbers.builder().range(1, 7).build());

        Purchase purchase = new Purchase(lottoCounter, new Lottos(Collections.singletonList(lotto)));

        Lottos lottos = purchase.drawLottos();

        assertThat(lottos.getLottoList())
                .contains(lotto)
                .hasSize(10);
    }
}