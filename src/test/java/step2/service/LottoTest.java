package step2.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.vo.LottoNumber;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static step2.service.LottoFixture.*;

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
                Arguments.arguments(lottoNumbers_3개_번호()),
                Arguments.arguments(lottoNumbers_5개_번호())
        );
    }

    @ParameterizedTest(name = "로또 번호와 승자 번호 동일한 숫자갯수 확인하는 테스트")
    @MethodSource("provideLottoNumbersAndWinNumbers")
    void countWinNumTest(List<LottoNumber> lottoNumbers, List<LottoNumber> winNumbers, LottoNumber bonusNumber, LottoRank expected) {
        Lotto lotto = new Lotto(lottoNumbers);
        LottoRank result = lotto.countWinNumber(winNumbers, bonusNumber);
        assertThat(result).isEqualTo(expected);
    }

    static Stream<Arguments> provideLottoNumbersAndWinNumbers() {
        return Stream.of(
                Arguments.arguments(createDefaultLottoNumber(), lottoNumbers_3개일치(), new LottoNumber(40), LottoRank.FIFTH),
                Arguments.arguments(createDefaultLottoNumber(), lottoNumbers_4개일치(), new LottoNumber(40), LottoRank.FOURTH),
                Arguments.arguments(createDefaultLottoNumber(), lottoNumbers_5개일치(), new LottoNumber(40), LottoRank.THIRD),
                Arguments.arguments(createDefaultLottoNumber(), lottoNumbers_5개일치_보너스(), new LottoNumber(6), LottoRank.SECOND),
                Arguments.arguments(createDefaultLottoNumber(), lottoNumbers_6개일치(), new LottoNumber(40), LottoRank.FIRST)
        );
    }
}
