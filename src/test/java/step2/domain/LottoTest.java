package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.strategy.ManualPick;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static step2.domain.Rank.RANK_5;

class LottoTest {

    @DisplayName("당첨번호와 몇개가 매칭되는지 테스트한다")
    @Test
    void pickNumberCheck() {
        Lotto lotto = new Lotto(new ManualPick("1, 2, 3, 4, 5, 6"));
        LottoWeeklyNumber lottoWeeklyNumber = new LottoWeeklyNumber("1,2,3,7,8,9", "10");

        assertThat(lotto.matching(lottoWeeklyNumber)).isEqualTo(RANK_5);
    }
}