package step2.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.vo.LottoNumber;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LottoTest {

    @ParameterizedTest(name = "LottoNumber 6개 아닌 경우 테스트")
    @MethodSource("provideNotSixSizeLotto")
    void validateSixSizeTest(List<LottoNumber> lottoNumbers) {
        assertThatCode(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호 갯수가 6개가 아닙니다.");
    }

    static Stream<Arguments> provideNotSixSizeLotto() {
        return Stream.of(
                Arguments.arguments(
                        List.of(
                                new LottoNumber(1),
                                new LottoNumber(2),
                                new LottoNumber(3),
                                new LottoNumber(4),
                                new LottoNumber(5)
                        )
                ),
                Arguments.arguments(
                        List.of(
                                new LottoNumber(1),
                                new LottoNumber(2),
                                new LottoNumber(3)
                        )
                )
        );
    }

    @ParameterizedTest(name = "로또 번호와 승자 번호 동일한 숫자갯수 확인하는 테스트")
    @MethodSource("provideLottoNumbersAndWinNumbers")
    void countWinNumTest(List<LottoNumber> lottoNumbers, List<Integer> winNumbers, int expected) {
        Lotto lotto = new Lotto(lottoNumbers);
        Integer result = lotto.countWinNum(winNumbers);
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> provideLottoNumbersAndWinNumbers() {
        return Stream.of(
                Arguments.arguments(createDefaultLottoNumber(), List.of(1, 2, 3, 43, 44, 45), 3),
                Arguments.arguments(createDefaultLottoNumber(), List.of(1, 2, 3, 4, 44, 45), 4),
                Arguments.arguments(createDefaultLottoNumber(), List.of(1, 2, 3, 4, 5, 45), 5)
        );
    }

    private static List<LottoNumber> createDefaultLottoNumber() {
        return List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        );
    }
}
