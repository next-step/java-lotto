package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoNumbersTest {


    @DisplayName("로또 번호가 6개가 아니거나 중복된 로또번호를 포함 시 IllegalArgumentException 발생")
    @ParameterizedTest(name = "{index}. {displayName}, arguments: {arguments}")
    @MethodSource("listParametersProvider")
    void create_ThrowsIllegalArgumentException_IfInputSizeIsNotSixOr(List<LottoNumber> lottoNumbers) {
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> new LottoNumbers(lottoNumbers));
    }


    private static List<LottoNumber> makeLottoNumbers(Integer... integers) {
        return Arrays.stream(integers)
                .map(LottoNumber::new)
                .collect(Collectors.toList());
    }

    static Stream<Arguments> listParametersProvider() {
        return Stream.of(
                Arguments.of(makeLottoNumbers(2, 6, 16, 24, 36)),
                Arguments.of(makeLottoNumbers(5, 9, 17, 28, 34, 37, 45)),
                Arguments.of(makeLottoNumbers(5, 9, 17, 17, 34, 37))
        );
    }
}
