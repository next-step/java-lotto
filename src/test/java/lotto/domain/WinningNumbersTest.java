package lotto.domain;

import lotto.StringParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class WinningNumbersTest {

    Lotto winningNumbers;

    @BeforeEach
    void setUp(){
        winningNumbers = Lotto.of(StringParser.getParseNumbers("1, 2, 3, 4, 5, 6"));
    }

    @DisplayName("당첨 번호 수가 안 맞는 경우 예외발생")
    @ParameterizedTest
    @MethodSource("listProvider")
    void numbersSizeTest(Set<Integer> numbers){
        LottoNumber bonusNumber = LottoNumber.of(9);
        assertThatThrownBy(() -> WinningNumbers.of(Lotto.of(numbers), bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> listProvider() {
        return Stream.of(
                arguments(StringParser.getParseNumbers("1, 2, 3, 4, 5, 6, 7")),
                arguments(StringParser.getParseNumbers("1, 2, 3, 4, 5")),
                arguments(new HashSet<>(Collections.emptyList()))
        );
    }

    @DisplayName("보너스볼 번호가 1 ~ 45 사이가 아닌 경우 예외발생")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void bonusNumberBoundaryTest(int number){

        // then
        assertThatThrownBy(() -> WinningNumbers.of(winningNumbers, LottoNumber.of(number)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("당첨번호와 보너스볼 중복시 예외발생")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void containsTest(int number) {
        // given
        LottoNumber bonusNumber = LottoNumber.of(number);

        // then
        assertThatThrownBy(() -> WinningNumbers.of(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("당첨 번호가 특정 번호를 가지고 있는지 여부 확인")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,true", "3,true", "7,false", "8,false"})
    void winningNumbersHasNumberTest(int number, boolean expected){
        // given
        LottoNumber lottoNumber = LottoNumber.of(number);
        LottoNumber bonusNumber = LottoNumber.of(9);
        WinningNumbers winningNumbers = WinningNumbers.of(this.winningNumbers, bonusNumber);

        // when
        boolean hasNumber = winningNumbers.hasNumber(lottoNumber);

        // then
        assertThat(hasNumber).isEqualTo(expected);
    }

}