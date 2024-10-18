package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoRankEnumTest {

    public static WinningLotto WINNING_LOTTO = new WinningLotto(new Lotto(new LottoNumbers(new int[]{1, 2, 3, 4, 5, 6})), new LottoNumber(8));

    @Test
    void FIRST() {
        Lotto lotto =  new Lotto(new LottoNumbers(new int[]{1,2,3,4,5,6}));
        assertThat(LottoRankEnum.FIRST.isMatch(WINNING_LOTTO, lotto)).isTrue();

    }

    @Test
    void SECOND() {
        Lotto lotto =  new Lotto(new LottoNumbers(new int[]{1,2,3,4,5,8}));
        assertThat(LottoRankEnum.SECOND.isMatch(WINNING_LOTTO, lotto)).isTrue();
    }

    @Test
    void THIRD() {
        Lotto lotto =  new Lotto(new LottoNumbers(new int[]{1,2,3,4,5,10}));
        assertThat(LottoRankEnum.THIRD.isMatch(WINNING_LOTTO, lotto)).isTrue();
    }

    @Test
    void FOURTH() {
        Lotto lotto =  new Lotto(new LottoNumbers(new int[]{1,2,3,4,8,10}));
        assertThat(LottoRankEnum.FOURTH.isMatch(WINNING_LOTTO, lotto)).isTrue();
    }

    @Test
    void FIVE() {
        Lotto lotto =  new Lotto(new LottoNumbers(new int[]{1,2,3,44,8,10}));
        assertThat(LottoRankEnum.FIVE.isMatch(WINNING_LOTTO, lotto)).isTrue();
    }

    @Test
    void LOS_LOT() {
        Lotto lotto =  new Lotto(new LottoNumbers(new int[]{1,2,45,44,8,10}));
        assertThat(LottoRankEnum.LOSING_LOT.isMatch(WINNING_LOTTO, lotto)).isTrue();
    }
}
