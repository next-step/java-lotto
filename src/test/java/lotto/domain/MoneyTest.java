package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

/**
 * 1. 음수 또는 0이 아닌 정수인 숫자를 가진다.\
 */
public class MoneyTest {
    @Test
    void create() {
        Money money = new Money(1000);
        assertThat(money).isEqualTo(new Money(1000));
    }

    @DisplayName("유효하지 않은 숫자를 가지는 돈 생성 실패 테스트")
    @ParameterizedTest
    @CsvSource({"0, 음수 또는 0이 아닌 숫자를 입력해주세요.",
            "ad, 잘몬된 값을 입력하였습니다."})
    void 음수_또는_0을_가지는_돈(String value, String expected) {
        assertThatThrownBy(() -> {
            new Money(value);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expected);
    }
}
