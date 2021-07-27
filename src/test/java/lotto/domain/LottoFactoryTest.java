package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("로또 팩토리")
class LottoFactoryTest {

    public static Stream<Arguments> validLottoNumbers() {
        return Stream.of(
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
            Arguments.of(Arrays.asList(1, 2, 4, 15, 20, 45))
        );
    }

    @DisplayName("[성공] 검증")
    @ParameterizedTest
    @MethodSource("validLottoNumbers")
    public void valid(List<Integer> numbers) {
        // given

        // when
        boolean result = LottoFactory.isValid(numbers);

        // then
        assertThat(result).isTrue();
    }

    public static Stream<Arguments> notValidLottoNumbers() {
        return Stream.of(
            Arguments.of(Arrays.asList(0, 1, 2, 3, 4, 5)),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 5)),
            Arguments.of(Arrays.asList(0, 5, 6, 7, 15, 46)),
            Arguments.of(Arrays.asList(1, 2, 6, 7))
        );
    }

    @DisplayName("[실패] 검증 - 유효하지 않은 로또 번호")
    @ParameterizedTest
    @MethodSource("notValidLottoNumbers")
    public void notValid(List<Integer> numbers) {
        // given

        // when
        boolean result = LottoFactory.isValid(numbers);

        // then
        assertThat(result).isFalse();
    }
}
