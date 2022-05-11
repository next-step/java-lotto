package lotto.domain;

import lotto.domain.LottoGame;
import lotto.domain.UserLottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoGameTest {
    @Test
    @DisplayName("구매금액 3,000 원의 구매가능수량은 3이다")
    void getQuantity() {
        assertThat(new LottoGame("3000").getMaxPurchasableQuantity()).isEqualTo(3);
    }

    @Test
    @DisplayName("구매금액 5000 원으로 자동을 돌린 후의 로또수량은 5이다")
    void auto() {
        LottoGame lotto = new LottoGame("5000");
        lotto.auto();
        assertThat(lotto.getBuyLottoNumbers()).hasSize(5);
    }

    @Test
    @DisplayName("로또 구매가능 수량 초과 추가시 예외가 발생한다")
    void lottoMultipleTimesCallAuto() {
        LottoGame lottoGame = new LottoGame("1000");
        lottoGame.auto();
        assertThatThrownBy(() -> lottoGame.auto());
    }

    @Test
    @DisplayName("로또구매가능수량을 초과하면 예외가 발생한다")
    void maxQuantityException() {
        UserLottos lottoNumbers = new UserLottos();
        lottoNumbers.autoCreate();
        lottoNumbers.autoCreate();

        assertThatThrownBy(() -> new LottoGame("1000", lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("수량을 초과하였습니다.");
    }

    @Test
    @DisplayName("구매금액이 1,000 단위가 아닐경우 예외가 발생한다")
    void buyPriceException() {
        assertThatThrownBy(() -> new LottoGame("1001"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1,000원 단위로만 구매 가능합니다.");
    }
}
