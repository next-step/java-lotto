package lotto.controller;

import lotto.model.LottoPrice;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoMainTest {

    @Test
    @DisplayName("로또 생성 시 금액이 1000원단위로 입력 되지 않은 경우 테스트")
    void createLottoGameCount() {
        int gamePrice = 14300;
        assertThatThrownBy(() -> new LottoPrice(gamePrice))
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("로또 금액은 1000원 단위로 구매 하셔야 합니다.");
    }

}
