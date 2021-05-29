package lotto;

import lotto.exception.LottoNumberRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @DisplayName("로또 번호 생성")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 45})
    void createLottoNumber_로또_번호_생성(int number){
        LottoNumber lottoNumber = new LottoNumber(number);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(number));
    }

    @DisplayName("보너스 볼 로또 번호 생성 예외")
    @ParameterizedTest
    @MethodSource("bonusNumberRangeError")
    void isbonusNumberRangeError_보너스_번호_범위_예외(List<LottoNumber> winLottoNumber, int bonusNumber){
        assertThatThrownBy(() -> new LottoNumber(new Lotto(() -> new LottoNumbers(winLottoNumber)), bonusNumber))
                .isInstanceOf(LottoNumberRangeException.class);
    }

    static Stream<Arguments> bonusNumberRangeError() {
        return Stream.of(
                Arguments.of(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(7), new LottoNumber(7))
                        , 55)
        );
    }
}
