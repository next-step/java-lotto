package lotto;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTest {

    @DisplayName("중복 되지 않은 숫자 6개로 만들어진다.")
    @MethodSource(value = "anyNumbers")
    @ParameterizedTest
    void a(List<Integer> anyNumbers) {
        List<LottoNumber> lottoNumbers = getLottoNumbers(anyNumbers);
        assertThatNoException().isThrownBy(() -> Lotto.from(lottoNumbers));
    }

    private static List<LottoNumber> getLottoNumbers(List<Integer> anyNumbers) {
        return anyNumbers.stream().map(LottoNumber::new)
            .collect(Collectors.toList());
    }

    @DisplayName("중복 된 숫자는 만들 수 없다.")
    @MethodSource(value = "anyNumbersDuplicated")
    @ParameterizedTest
    void b(List<Integer> anyNumbersDuplicated) {
        List<LottoNumber> lottoNumbers = getLottoNumbers(anyNumbersDuplicated);
        assertThatThrownBy(() -> Lotto.from(lottoNumbers));
    }

    private static Stream<Arguments> anyNumbers() {
        return Stream.of(
            Arguments.of(List.of(7, 14, 21, 28, 35, 42)),
            Arguments.of(List.of(3, 10, 17, 24, 31, 38)),
            Arguments.of(List.of(11, 18, 25, 32, 39, 45)),
            Arguments.of(List.of(2, 9, 16, 23, 30, 37)),
            Arguments.of(List.of(8, 15, 22, 29, 36, 43))
        );
    }

    private static Stream<Arguments> anyNumbersDuplicated() {
        return Stream.of(
            Arguments.of(List.of(7, 14, 7, 28, 35, 42)),
            Arguments.of(List.of(3, 10, 17, 17, 31, 38)),
            Arguments.of(List.of(11, 18, 32, 32, 39, 45)),
            Arguments.of(List.of(2, 9, 9, 23, 30, 37)),
            Arguments.of(List.of(8, 15, 22, 22, 36, 43))
        );
    }

}
