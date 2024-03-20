package lotto;

import lotto.domain.Cash;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CashTest {

    Cash cash;

    @BeforeEach
    void setUp(){
        cash = new Cash();
    }

    @Test
    void less_than_1000() {
        assertThatThrownBy(() -> {
            cash.payLotto(999);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "20123:20"}, delimiter = ':')
    void more_than_1000(int money, int count) {
        int result = cash.payLotto(money);
        assertThat(result).isEqualTo(count);
    }
}
