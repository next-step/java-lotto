package step2.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.vo.LottoNumber;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static step2.service.LottoFixture.lottoNumbers_3개_번호;
import static step2.service.LottoFixture.lottoNumbers_5개_번호;

public class LottoTest {

    @ParameterizedTest(name = "LottoNumber 6개 아닌 경우 테스트")
    @MethodSource("provideNotSixSizeLotto")
    void validateSixSizeTest(Set<LottoNumber> lottoNumbers) {
        assertThatCode(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호 갯수가 6개가 아닙니다.");
    }

    static Stream<Arguments> provideNotSixSizeLotto() {
        return Stream.of(
                Arguments.arguments(lottoNumbers_3개_번호()),
                Arguments.arguments(lottoNumbers_5개_번호())
        );
    }
}
