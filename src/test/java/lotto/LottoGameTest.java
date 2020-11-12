package lotto;

import lotto.exception.IllegalInputAmountException;
import lotto.mock.MockInvalidAmountView;
import lotto.service.LottoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoGameTest {
    private LottoGame lottoGame;

    @BeforeEach
    void init() {
        lottoGame = new LottoGame(new MockInvalidAmountView(), new LottoService());
    }

    @Test
    @DisplayName("amount의 음수가 입력된 경우 throw IllegalInputAmountException")
    void negativeAmountInputTest() {
        assertThatExceptionOfType(IllegalInputAmountException.class)
                .isThrownBy(() -> lottoGame.start())
                .withMessage(LottoGame.INVALID_AMOUNT_ERR_MSG);
    }
}
