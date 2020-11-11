package lotto;

import lotto.exception.IllegalInputAmountException;
import lotto.mock.MockInvalidAmountView;
import lotto.service.LottoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoGameTest {
    private LottoGame lottoGame;

    @BeforeEach
    void init() {
        lottoGame = new LottoGame(new MockInvalidAmountView(), new LottoServiceImpl());
    }

    @Test
    void test() {
        assertThatExceptionOfType(IllegalInputAmountException.class)
                .isThrownBy(() -> lottoGame.start())
                .withMessage(LottoGame.INVALID_AMOUNT_ERR_MSG);
    }
}
