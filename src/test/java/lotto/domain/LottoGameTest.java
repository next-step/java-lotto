package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    private List<Integer> winningLotto;
    private int bonusNo;

    @BeforeEach
    void setUp() {
        winningLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        bonusNo = 7;
    }

    @Test
    public void match_1등() {
        List<Integer> userLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(LottoGame.match(userLotto, winningLotto, bonusNo)).isEqualTo(1);
    }

    @Test
    public void match_2등() {
        List<Integer> userLotto = Arrays.asList(1, 2, 3, 4, 5, 7);
        assertThat(LottoGame.match(userLotto, winningLotto, bonusNo)).isEqualTo(2);
    }

    @Test
    public void match_3등() {
        List<Integer> userLotto = Arrays.asList(1, 2, 3, 4, 5, 8);
        assertThat(LottoGame.match(userLotto, winningLotto, bonusNo)).isEqualTo(3);
    }

    @Test
    public void match_4등() {
        List<Integer> userLotto = Arrays.asList(1, 2, 3, 4, 7, 8);
        assertThat(LottoGame.match(userLotto, winningLotto, bonusNo)).isEqualTo(4);
    }

    @Test
    public void match_5등() {
        List<Integer> userLotto = Arrays.asList(1, 2, 3, 7, 8, 9);
        assertThat(LottoGame.match(userLotto, winningLotto, bonusNo)).isEqualTo(5);
    }

    @Test
    public void match_꽝() {
        List<Integer> userLotto = Arrays.asList(1, 2, 7, 8, 9, 10);
        assertThat(LottoGame.match(userLotto, winningLotto, bonusNo)).isEqualTo(0);
    }
}
