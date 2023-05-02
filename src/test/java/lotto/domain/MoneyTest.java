package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MoneyTest {

    @Test
    @DisplayName("Money  생성 테스트")
    void initMoneyTest() {
        assertThat(Money.wons(3000))
                .isInstanceOf(Money.class);
    }


    @ParameterizedTest
    @ValueSource(ints = {0, -1, 999})
    @DisplayName("1000보다 작은 값을 보낼 때 에러를 던진다")
    void nullOrEmptyTest(int input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Money.wons(input))
                .withMessage("1000원 이상 입력해주세 :)");
    }
}