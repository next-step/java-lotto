package lotto.util;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RequestTest {

    @Test
    void buyMoneyLotto_test() {
        Request request = new Request(5000);
        assertThat(request.getLotto().size()).isEqualTo(5);
    }
}