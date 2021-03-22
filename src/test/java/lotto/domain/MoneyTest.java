package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {

    @Test
    void createMoneyTest_성공() {
        assertThat(new Money("5000").value()).isEqualTo(5000);
    }

    @Test
    void createMoneyTest_음수() {
        assertThatThrownBy(()-> new Money("-1")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void createMoneyTest_문자() {
        assertThatThrownBy(()-> new Money("a")).isInstanceOf(IllegalArgumentException.class);
    }
}
