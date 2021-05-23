package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {

    @DisplayName("1000원 이상 생성시 에러없이 생성")
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
