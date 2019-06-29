package edu.nextstep.step4.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * author       : gwonbyeong-yun <sksggg123>
 * ------------------------------------------
 * | email        : sksggg123               |
 * | github       : github.com/sksggg123    |
 * | blog         : sksggg123.github.io     |
 * ------------------------------------------
 * project      : java-lotto
 * create date  : 2019-06-25 02:27
 */
class RankTest {

    @DisplayName("Values 값을 얻는다.")
    @Test
    void getValues() {
        assertThat(Rank.getRanks().get(0) == Rank.ZERO).isTrue();
    }

    @DisplayName("match 값을 얻는다.")
    @Test
    void getMatch() {
        assertThat(Rank.getRanks().get(0).getMatch()).isEqualTo(0);
    }

    @DisplayName("money 값을 얻는다.")
    @Test
    void getMoney() {
        assertThat(Rank.getRanks().get(5).getLotteryMoney()).isEqualTo(2_000_000_000);
    }

    @DisplayName("bonus 여부를 얻는다.")
    @Test
    void getBonus() {
        assertThat(Rank.getRanks().get(4).getBonusRank()).isTrue();
    }
}