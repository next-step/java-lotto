package lotto_test;

import lotto_auto.lotto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class lotto_test {
    @ValueSource(strings = {"1000"})
    @ParameterizedTest
    void 금액제한_1000원이상구매가능(String strs) {
        final lotto lottoBuyAmt = new lotto();
        assertThat(lottoBuyAmt.getBuyAmt(strs)).isEqualTo("1000");
    }

}
