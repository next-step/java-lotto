package lotto.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static lotto.helper.Generator.lottoNumbersOf;
import static lotto.number.LottoNumbers.NUMBER_OF_LOTTO_NUMBERS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로또 숫자 그룹 테스트")
class LottoNumbersTest {

    @DisplayName("로또 번호 그룹은 " + NUMBER_OF_LOTTO_NUMBERS + "개의 로또 번호가지고 생성한다.")
    @Test
    void initLottoNumbers() {
        List<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, NUMBER_OF_LOTTO_NUMBERS)
                .mapToObj(LottoNumber::from)
                .collect(Collectors.toList());

        assertThat(LottoNumbers.from(lottoNumbers)).isNotNull();
    }

    @DisplayName("로또 번호 생성기에 " + NUMBER_OF_LOTTO_NUMBERS + "이 아닌 값이 오거나 null 이 올경우 예외를 던진다.")
    @NullSource
    @MethodSource
    @ParameterizedTest
    void initLottoNumbersException(List<LottoNumber> lottoNumbers) {
        assertThatThrownBy(() -> LottoNumbers.from(lottoNumbers)).isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> initLottoNumbersException() {
        return Stream.of(
                Arguments.of(lottoNumbersOf(1, 2, 3, 4, 5)),
                Arguments.of(lottoNumbersOf(1, 2, 3, 4, 5, 6, 7))
        );
    }
}
