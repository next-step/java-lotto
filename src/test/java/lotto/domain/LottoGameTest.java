package lotto.domain;

import lotto.dto.WinningResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame((count) -> List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
    }

    @Test
    void 당첨_결과() {
        String winningNumber = "1, 2, 3, 4, 5, 6";
        WinningResult result = lottoGame.match(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))), winningNumber);
        assertThat(result).isEqualTo(new WinningResult(List.of(new Winning(3, 0), new Winning(4, 0), new Winning(5, 0), new Winning(6, 1)), new BigDecimal("2000000.00")));
    }

    @Test
    void 로또_발급() {
        assertThat(lottoGame.create("1000")).isEqualTo(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6))));
    }
}
