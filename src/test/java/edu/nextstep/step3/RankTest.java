package edu.nextstep.step3;

import edu.nextstep.step2.Rank;
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
        assertThat(Rank.getRanks().get(0) == Rank.THREE).isTrue();
    }
}