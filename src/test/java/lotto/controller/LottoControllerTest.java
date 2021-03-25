package lotto.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoControllerTest {

    @Test
    @DisplayName("로또 구매한 회수 구하기")
    void getLottoPurchaseCountTest() {
        LottoController lottoController = new LottoController();
        assertThat(lottoController.getLottoPurchaseCount(14000)).isEqualTo(14);
    }
}
