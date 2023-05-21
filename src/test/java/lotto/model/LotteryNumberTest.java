package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LotteryNumberTest {

    @Test
    void 로또_숫자_범위를_벗어나면_에러() {
        assertThatThrownBy(() -> LotteryNumber.of(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 로또 번호입니다.");
        assertThatThrownBy(() -> LotteryNumber.of(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 로또 번호입니다.");
    }

}
