package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @DisplayName("금액을 넣으면 돈이 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {1000, 1200, 2000})
        //given
    void create(final int money) {
        //when
        final int result = new Money(money).getMoney();

        //then
        assertThat(result).isEqualTo(money);
    }
}
