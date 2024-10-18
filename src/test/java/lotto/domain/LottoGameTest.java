package lotto.domain;

import lotto.enumeration.Rank;
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
        lottoGame = new LottoGame((count) -> List.of(new Lotto(1, 2, 3, 4, 5, 6)));
    }

    @Test
    void 당첨_결과() {
        WinningResult result = lottoGame.match(List.of(new Lotto(1, 2, 3, 4, 5, 6), new Lotto(11, 12, 13, 14, 15, 16), new Lotto(1, 2, 3, 4, 5, 7)), new InputNumber("1, 2, 3, 4, 5, 6", "7"));
        assertThat(result).isEqualTo(new WinningResult(List.of(new Winning(Rank.FIRST, 1), new Winning(Rank.SECOND, 1), new Winning(Rank.MISS, 1)), new BigDecimal("676666.66")));
    }

    @Test
    void 로또_발급() {
        assertThat(lottoGame.create("1000")).isEqualTo(List.of(new Lotto(1, 2, 3, 4, 5, 6)));
    }
}
