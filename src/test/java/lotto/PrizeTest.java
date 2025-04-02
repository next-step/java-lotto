package lotto;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeTest {

    @Test
    @DisplayName("로또 맞춘 개수와 일치하는 상금 정보 반환")
    void 로또_맞춘_개수와_일치하는_상금_정보_반환() {
        int count = 3;

        Prize prize = Prize.valueOfCount(count);

        assertThat(prize).isEqualTo(Prize.FOUR);
    }

    @Test
    @DisplayName("로또 맞춘 개수와 일치하는 상금 정보 반환")
    void 로또_맞춘_개수와_일치하는_상금_정보_반환_NONE() {
        int count = 0;

        Prize prize = Prize.valueOfCount(count);

        assertThat(prize).isEqualTo(Prize.NONE);
    }

}