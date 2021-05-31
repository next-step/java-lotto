package step5;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step5.domain.LottoGame;
import step5.domain.Rank;
import step5.domain.WinningLotto;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    private List<Integer> winningLotto;
    private int bonusNo;

    @BeforeEach
    void setUp() {
        winningLotto = Arrays.asList(1,2,3,4,5,6);
        bonusNo = 7;
    }

    @Test
    void match_1등() {
        List<Integer> userLotto = Arrays.asList(1,2,3,4,5,6);
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(1,2,3,4,5,6),7);
        assertThat(LottoGame.match(userLotto,winningLotto)).isEqualTo(Rank.FIRST);
    }




}
