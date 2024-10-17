package lotto.domain;

import lotto.vo.Winning;
import lotto.vo.WinningResult;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    private LottoGame lottoGame;

    @BeforeEach
    void setUp() {
        lottoGame = new LottoGame((count) -> List.of(new Lotto(List.of(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6)))));
    }

    @Test
    void 당첨_결과() {
        String winningNumber = "1, 2, 3, 4, 5, 6";
        WinningResult result = lottoGame.match(List.of(new Lotto(List.of(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6))), new Lotto(List.of(new Number(11), new Number(12), new Number(13), new Number(14), new Number(15), new Number(16)))), winningNumber);
        assertThat(result).isEqualTo(new WinningResult(List.of(new Winning(3, 0), new Winning(4, 0), new Winning(5, 0), new Winning(6, 1)), new BigDecimal("1000000.00")));
    }

    @Test
    void 로또_발급() {
        assertThat(lottoGame.create("1000")).isEqualTo(List.of(new Lotto(List.of(new Number(1), new Number(2), new Number(3), new Number(4), new Number(5), new Number(6)))));
    }
}
