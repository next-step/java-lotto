package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoRankEnumTest {

//    public static WinningLotto WINNING_LOTTO = new WinningLotto(new Lotto(new LottoNumbers(new int[]{1, 2, 3, 4, 5, 6})), new LottoNumber(8));

    @Test
    void getRank_FIRST() {
        LottoRankEnum expectedRank = LottoRankEnum.getRank(6, false);
        Assertions.assertThat(expectedRank).isEqualTo(LottoRankEnum.FIRST);
    }

    @Test
    void getRank_SECOND() {
        LottoRankEnum expectedRank = LottoRankEnum.getRank(5, true);
        Assertions.assertThat(expectedRank).isEqualTo(LottoRankEnum.SECOND);
    }


    @Test
    void getRank_THIRD() {
        LottoRankEnum expectedRank = LottoRankEnum.getRank(5, false);
        Assertions.assertThat(expectedRank).isEqualTo(LottoRankEnum.THIRD);
    }

    @Test
    void getRank_LOSING_LOT() {
        LottoRankEnum expectedRank = LottoRankEnum.getRank(1, false);
        Assertions.assertThat(expectedRank).isEqualTo(LottoRankEnum.LOSING_LOT);
    }

    @Test
    void getRank_FOURTH() {
        LottoRankEnum expectedRank = LottoRankEnum.getRank(4, false);
        Assertions.assertThat(expectedRank).isEqualTo(LottoRankEnum.FOURTH);
    }

    @Test
    void getRank_FIVE() {
        LottoRankEnum expectedRank = LottoRankEnum.getRank(3, false);
        Assertions.assertThat(expectedRank).isEqualTo(LottoRankEnum.FIVE);
    }
}
