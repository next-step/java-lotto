package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoTest {

    static Stream<Arguments> generateLotto() {
        return Stream.of(
            Arguments.of(Arrays.asList()),
            Arguments.of(Arrays.asList(1)),
            Arguments.of(Arrays.asList(1, 2)),
            Arguments.of(Arrays.asList(1, 2, 3)),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6)),
            Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7)),
            Arguments.of(Arrays.asList(10, 20, 30, 40, 9, 45))
        );
    }

    @DisplayName(value = "정수형 리스트로 Lotto 인스턴스 생성시, 인스턴스의 크기는 정수형 리스트와 동일하다.")
    @ParameterizedTest
    @MethodSource("generateLotto")
    void GivenListWithIntType_WhenCreateInstance_ThenInstanceSizeIsEqualtoListWithIntType(
        List<Integer> lotto) {
        final int lottoSize = Lotto.from(lotto).getLotto().size();

        assertThat(lottoSize)
            .isEqualTo(lotto.size());
    }
}
