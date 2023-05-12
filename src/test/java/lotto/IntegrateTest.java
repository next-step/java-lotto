package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegrateTest {
    LottoGameService lottoGameService;

    @BeforeEach
    void init() {
        lottoGameService = LottoGameService.from();
    }

    @Test
    @DisplayName("통합 테스트")
    void integrateTest() {
        lottoGameService.buyTickets();
        lottoGameService.inputWinningNumber();
        lottoGameService.lottoResult();
    }
}
