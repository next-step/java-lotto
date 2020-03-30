package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BonusBallTest {

    @DisplayName("보너스 볼 객체를 생성할 수 있다.")
    @Test
    void create() {
        BonusBall expect = new BonusBall("1");

        BonusBall actual = new BonusBall("1");

        assertThat(actual).isEqualTo(expect);
    }

}