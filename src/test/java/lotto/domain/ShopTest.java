package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ShopTest {
    @Test
    @DisplayName("로또 구매 테스트")
    public void purchaseLottoTest() {
        assertThat(Shop.purchaseLotto(3000).size()).isEqualTo(3);
    }

    @Test
    @DisplayName("로또 구매 금액 오류 테스트 - 음수 입력")
    public void purchaseLottoNegativeNumError() {
        assertThatThrownBy(() -> Shop.purchaseLotto(-1000).size())
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("구매 금액은 음수가 될 수 없습니다.");
    }

    @Test
    @DisplayName("로또 구매 금액 오류 테스트 - 1000 단위 예외 입력")
    public void purchaseLotto1000UnitErrorTest() {
        assertThatThrownBy(() -> Shop.purchaseLotto(3500))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1000원 단위로 구입할 수 있습니다.");
    }
}
