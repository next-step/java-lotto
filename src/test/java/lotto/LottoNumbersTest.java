package lotto;

import lotto.exception.LottoSizeOrDuplicateException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumbersTest {
    @DisplayName("로또 번호 생성 테스트")
    @ParameterizedTest
    @MethodSource("createLottoNumber")
    void createLottoNumber_로또_일치_검증(List<LottoNumber> lotto, List<LottoNumber> compareLotto) {
        LottoNumbers lottoNumbers = new LottoNumbers(lotto);
        assertThat(lottoNumbers).isEqualTo(new LottoNumbers(compareLotto));
    }

    static Stream<Arguments> createLottoNumber() {
        return Stream.of(
                Arguments.of(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)),
                Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)))
        );
    }

    @DisplayName("로또 번호 유효성 체크 ( 6자리 / 중복 )")
    @ParameterizedTest
    @MethodSource("isRightNumber")
    void isRightNumber_로또_번호_유효성_체크(List<LottoNumber> lottoNumber) {
        assertThatThrownBy(() -> new LottoNumbers(lottoNumber))
                .isInstanceOf(LottoSizeOrDuplicateException.class);
    }

    static Stream isRightNumber() {
        return Stream.of(
                Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6), new LottoNumber(7)),
                Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(6), new LottoNumber(6))
        );
    }
}
