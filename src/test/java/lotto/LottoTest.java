package lotto;

import lotto.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoTest {

    InputView inputView;

    @BeforeEach
    public void setup(){
        inputView = new InputView();
    }

    @Test
    @DisplayName("입력 받은 금액 정합성 체크")
    public void inputMoneyNormal(){
        assertTrue(inputView.normal(15000));
        assertFalse(inputView.normal(15999));
        assertFalse(inputView.normal(-1000));
    }
}
