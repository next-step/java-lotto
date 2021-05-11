package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LottoBallsTest {

    static Stream<Arguments> comparingList() {
        return Stream.of(
                arguments(
                        LottoBalls.createManualLottoBalls(1, 2, 3, 4, 5, 6),
                        LottoBalls.createManualLottoBalls(1, 12, 3, 4, 5, 6),
                        5
                )
        );
    }

    @Test
    @DisplayName("로또 생성")
    void create() {
        assertThat(LottoBalls.createManualLottoBalls(1, 2, 3, 4, 5, 6)).isNotNull();
    }

    @Test
    @DisplayName("로또 생성 범위 오류")
    void validate_range() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoBalls.createManualLottoBalls(51, 52, 53, 54, 55, 56));
    }

    @Test
    @DisplayName("로또 생성 개수 오류")
    void validate_size() {
        assertThatIllegalArgumentException().isThrownBy(() -> LottoBalls.createManualLottoBalls(1, 2, 3, 4, 5));
    }

    @ParameterizedTest
    @DisplayName("당첨 번호 포함 개수 확인")
    @MethodSource("comparingList")
    void check(LottoBalls baseLottoBalls, LottoBalls winningLottoBalls, int expected) {
        int actualCount = baseLottoBalls.count(winningLottoBalls);
        assertThat(actualCount).isEqualTo(expected);
    }
}
