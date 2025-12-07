package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    @Test
    @DisplayName("입력된 금액만큼의 로또가 생성되어야 한다")
    void generate_lotto() {
        LottoPurchase lottoPurchase = new LottoPurchase(new LottoCount(14));
        assertThat(new LottoGame(lottoPurchase).lottoCount()).isEqualTo(14);
    }
}