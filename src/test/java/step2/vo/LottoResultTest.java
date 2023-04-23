package step2.vo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    private LottoResult lottoResult = new LottoResult(List.of(1, 2, 3, 4, 5, 6));

    @ParameterizedTest(name = "뽑은 로또 번호와 승자 로또 번호가 몇 개 일치하는지 확인하는 테스트")
    @MethodSource("provideLottoNumbers")
    void countMatchingNumbers_로또_결과_승자_결과_확인(List<Integer> lottoNumbers, int expected) {
        int result = lottoResult.countMatchingNumbers(lottoNumbers);
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> provideLottoNumbers() {
        return Stream.of(
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 6), 6),
                Arguments.arguments(List.of(1, 2, 3, 4, 5, 45), 5),
                Arguments.arguments(List.of(1, 2, 3, 4, 44, 45), 4),
                Arguments.arguments(List.of(1, 2, 3, 43, 44, 45), 3),
                Arguments.arguments(List.of(1, 2, 42, 43, 44, 45), 2),
                Arguments.arguments(List.of(1, 41, 42, 43, 44, 45), 1),
                Arguments.arguments(List.of(40, 41, 42, 43, 44, 45), 0)
        );
    }
}
