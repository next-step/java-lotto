package lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoBallPolicyTest {

    @Test
    void getLottoNumber() {
        LottoBallPolicy lottoBallPolicy = new LottoBallPolicy();

        var expectSize = 6;
        var actualSize = lottoBallPolicy.getLottoNumber(6).size();

        assertThat(actualSize).isEqualTo(expectSize);
    }
}