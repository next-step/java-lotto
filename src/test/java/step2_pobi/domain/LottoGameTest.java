package step2_pobi.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

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
        assertThat(LottoGame.match(userLotto, winningLotto, bonusNo)).isEqualTo(Rank.FIRST);
    }

}