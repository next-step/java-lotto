package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoBallTest {

    @Test
    @DisplayName("로또 번호 생성 테스트 - 생성자")
    void create_constructor() {
        assertAll(
                () -> assertThat(new LottoBall(1).toStringValue()).isEqualTo("1"),
                () -> assertThat(new LottoBall(45).toStringValue()).isEqualTo("45")
        );
    }

    @Test
    @DisplayName("로또 번호 생성 테스트 - valueOf")
    void create_valueOf() {
        assertAll(
                () -> assertThat(LottoBall.valueOf(1).toStringValue()).isEqualTo("1"),
                () -> assertThat(LottoBall.valueOf(45).toStringValue()).isEqualTo("45")
        );
    }

    @ParameterizedTest
    @DisplayName("로또 번호 생성 실패 테스트")
    @ValueSource(ints = {-1, 0, 46})
    void validate(int number) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoBall.valueOf(number));
    }
}
