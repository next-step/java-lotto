package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LotteryTest {

    @DisplayName("로또 복권은 6개의 숫자를 가진다.")
    @Test
    void create() {
        Lottery expect = new Lottery("1", "2", "3", "4", "5", "6");

        Lottery actual = new Lottery("1", "2", "3", "4", "5", "6");

        assertThat(actual).isEqualTo(expect);
    }
}