package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    private Lotto winningNumber;
    private Lotto lotto;

    @BeforeEach
    public void setup() {
        lotto = new Lotto(1, 2, 3, 4, 5, 6);
    }

    @Test
    public void match_6개_테스트() {
        winningNumber = new Lotto(1, 2, 3, 4, 5, 6);
        assertThat(LottoGame.match(lotto, winningNumber)).isEqualTo(Rank.valueOf(6));
    }

    @Test
    public void match_3개_테스트() {
        winningNumber = new Lotto(1, 2, 3, 7, 8, 9);
        assertThat(LottoGame.match(lotto, winningNumber)).isEqualTo(Rank.valueOf(3));
    }
}
