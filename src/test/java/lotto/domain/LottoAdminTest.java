package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAdminTest {
    private LottoAdmin lottoAdmin = new LottoAdmin(Arrays.asList(1,2,3,4,5,6));

    @Test
    @DisplayName("1등 당첨 test")
    void firstWinningTest() {
        assertThat(lottoAdmin.calculateRank(new Lotto(Arrays.asList(6,5,4,3,2,1)))).isEqualTo(Rank.FIRST);
    }

    @Test
    @DisplayName("3등 당첨 test")
    void thirdWinningTest() {
        assertThat(lottoAdmin.calculateRank(new Lotto(Arrays.asList(11,5,9,3,8,1)))).isEqualTo(Rank.FORTH);
    }

    @Test
    @DisplayName("미당첨 test")
    void notWinningTest() {
        assertThat(lottoAdmin.calculateRank(new Lotto(Arrays.asList(11,43,9,26,8,15)))).isEqualTo(Rank.MISS);
    }

    @Test
    @DisplayName("입력값 split test")
    void splitLottoStringTest() {
        LottoAdmin splitLottoAdmin = new LottoAdmin("1, 2, 3, 4, 5, 6");
        assertThat(lottoAdmin.equals(splitLottoAdmin)).isEqualTo(true);
    }

}
