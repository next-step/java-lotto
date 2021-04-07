package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoBallTest {

    @ParameterizedTest
    @DisplayName("로또 번호 생성 테스트")
    @ValueSource(ints = {1, 45})
    void create(int ball) {
        assertThat(LottoBall.valueOf(ball)).isNotNull();
    }

    @ParameterizedTest
    @DisplayName("로또 번호 생성 실패 테스트")
    @ValueSource(ints = {-1, 0, 46})
    void validate(int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoBall.valueOf(number));
    }
}
