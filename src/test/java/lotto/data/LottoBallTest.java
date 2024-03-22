package lotto.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoBallTest {

    @DisplayName("로또 볼은 0이하 혹은 46이상의 값을 가질경우 IllegalArgumentException을 던진다.")
    @Test
    void validateLottoBallNumberOutOfRange() {
        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoBall.selectLottoBall(0));
        Assertions.assertThrows(IllegalArgumentException.class, () -> LottoBall.selectLottoBall(46));
    }
}
