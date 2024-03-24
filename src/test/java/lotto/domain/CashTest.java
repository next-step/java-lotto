package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CashTest {

    Cash cash;

    @BeforeEach
    void setUp() {
        cash = new Cash();
    }

    @Test
    @DisplayName("1000보다 작으면 예외(999 => IllegalArgumentException)")
    void less_than_1000() {
        assertThatThrownBy(() -> {
            cash.payLotto(999);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("1000으로 나눈 몫을 반환(14000 => 14, 20123 => 20)")
    @CsvSource(value = {"14000:14", "20123:20"}, delimiter = ':')
    void more_than_1000(int money, int count) {
        int result = cash.payLotto(money);
        assertThat(result).isEqualTo(count);
    }

    @Test
    void to_string() {
        cash = new Cash(10);
        assertThat(cash.toString()).isEqualTo(10 + "개를 구매했습니다.");
    }
}
