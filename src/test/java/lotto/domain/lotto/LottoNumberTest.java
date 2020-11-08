package lotto.domain.lotto;

import lotto.domain.exception.InvalidRangeLottoNumbersException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("로또 번호 테스트")
public class LottoNumberTest {
    @DisplayName("로또 생성시 숫자가 0이하이거나 45보다 큰 경우")
    @ParameterizedTest
    @MethodSource("getInvalidRangeNumbers")
    public void makeLottoWithInvalidRangeNumber(int invalidNumber) {
        assertThatThrownBy(() -> {
            LottoNumber.of(invalidNumber);
        }).isInstanceOf(InvalidRangeLottoNumbersException.class)
                .hasMessageContaining("로또 숫자는 1이상 45이하여야 합니다.");
    }

    static Stream<Integer> getInvalidRangeNumbers() {
        return Stream.of(-1, 0, 46, 47);
    }

    @DisplayName("로또 번호 동등비교 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:3:true", "34:34:true", "3:1:false", "23:21:false"}, delimiter = ':')
    public void equalsLottoNumber(int leftNumber, int rightNumber, boolean expectedResult) {
        boolean result = LottoNumber.of(leftNumber).equals(LottoNumber.of(rightNumber));

        assertThat(result).isEqualTo(expectedResult);
    }
}