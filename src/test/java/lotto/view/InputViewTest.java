package lotto.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest {
    @Test
    @DisplayName("로또 구매금액만큼 로또 생성")
    void createLottoTest() {
        InputView inputView = new InputView();
        inputView.buyLotto(3000);
    }

    @Test
    @DisplayName("로또 금액 예외(천원단위가 아닐때)")
    void priceExceptionTest() {
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.buyLotto(999))
                                          .isInstanceOf(IllegalArgumentException.class)
                                          .hasMessageContaining("천원 단위로 입력해야 합니다.");
    }

    @Test
    @DisplayName("로또 금액 예외(천원보다 작을때)")
    void priceExceptionTest2() {
        InputView inputView = new InputView();

        assertThatThrownBy(() -> inputView.buyLotto(900))
                                          .isInstanceOf(IllegalArgumentException.class)
                                          .hasMessageContaining("작습니다.");
    }
}