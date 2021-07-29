package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @DisplayName("천원부터 십만원까지 범위를 벗어나면 에러")
    @ParameterizedTest
    @ValueSource(ints = {-1, 999, 100001})
    void validate_fail(int value) {
        assertThatThrownBy(() -> new Money(value)).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("천원부터 십만원까지 구매 성공")
    @ParameterizedTest
    @ValueSource(ints = {1000, 100000})
    void validate_success(int value) {
        assertThat(new Money(value));
    }

    @DisplayName("금액 당 구매할수 있는 로또 개수 확인")
    @ParameterizedTest
    @CsvSource(value = {"1000 : 1", "100000 : 100", "5000 : 5", "30000 : 30"}, delimiter = ':')
    void countLotto(int money, int count) {
        assertThat(new Money(money).countLotto()).isEqualTo(count);
    }

}