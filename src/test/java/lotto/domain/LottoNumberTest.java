package lotto.domain;

import lotto.constants.LottoConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class LottoNumberTest {

    @Test
    @DisplayName("from 호출할 때 매개변수 리스트의 size 6이 아니면 IllegalArgumentException")
    void from_list_size_exception() {
        assertThatThrownBy(() -> LottoNumber.from(List.of(1, 2, 3, 4, 5))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> LottoNumber.from(List.of(1, 2, 3, 4, 5, 6, 7))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("from 호출할 때 매개변수 리스트의 요소가 최솟값보다 작은 경우 IllegalArgumentException")
    void from_min_number_valid_exception() {
        int invalidNumber = LottoConstants.MIN_LOTTO_NUMBER - 1;
        assertThatThrownBy(() -> LottoNumber.from(List.of(invalidNumber, 3, 5, 10, 33, 45))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("from 호출할 때 매개변수 리스트의 요소가 최대값보다 작은 경우 IllegalArgumentException")
    void from_max_number_valid_exception() {
        int invalidNumber = LottoConstants.MAX_LOTTO_NUMBER + 1;
        assertThatThrownBy(() -> LottoNumber.from(List.of(invalidNumber, 1, 5, 10, 33, 45))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("from 호출 시 LottoNumber 생성하여 정상 반환")
    void from_success() {
        LottoNumber lottoNumber = LottoNumber.from(List.of(1,2,3,4,5,6));

        assertThat(lottoNumber.size()).isEqualTo(6);
    }

    @ParameterizedTest(name = "동일한 숫자 개수 : {2}")
    @MethodSource("lottoNumbersAndContainsCount")
    @DisplayName("containsCount 호출 시 넘어오는 LottoNumber와 동일한 숫자의 개수 반환")
    void containsCount(LottoNumber lottoNumber, LottoNumber winnerNumber, int containsCount) {
        assertThat(lottoNumber.containsCount(winnerNumber)).isEqualTo(containsCount);
    }

    @ParameterizedTest
    @MethodSource("lottoNumbersAndString")
    @DisplayName("getNumbersToString 호출 시 로또 번호를 문자열로 반환")
    void getNumbersToString(LottoNumber lottoNumber, String expected) {
        assertThat(lottoNumber.getNumbersToString()).isEqualTo(expected);
    }

    static Stream<Arguments> lottoNumbersAndContainsCount() {
        LottoNumber lottoNumber = LottoNumber.from(List.of(1, 2, 3, 4, 5, 6));
        return Stream.of(
                Arguments.arguments(lottoNumber, LottoNumber.from(List.of(1, 2, 3, 4, 5, 6)), 6),
                Arguments.arguments(lottoNumber, LottoNumber.from(List.of(1, 2, 3, 4, 5, 42)), 5),
                Arguments.arguments(lottoNumber, LottoNumber.from(List.of(1, 2, 3, 4, 29, 38)), 4),
                Arguments.arguments(lottoNumber, LottoNumber.from(List.of(1, 2, 3, 30, 31, 32)), 3)
        );
    }

    static Stream<Arguments> lottoNumbersAndString() {
        return Stream.of(
                Arguments.arguments(LottoNumber.from(List.of(1, 2, 3, 4, 5, 6)), "[1, 2, 3, 4, 5, 6]"),
                Arguments.arguments(LottoNumber.from(List.of(22, 30, 31, 37, 41, 42)), "[22, 30, 31, 37, 41, 42]"),
                Arguments.arguments(LottoNumber.from(List.of(5, 11, 23, 29, 30, 38)), "[5, 11, 23, 29, 30, 38]"),
                Arguments.arguments(LottoNumber.from(List.of(1, 2, 3, 30, 31, 32)), "[1, 2, 3, 30, 31, 32]")
        );
    }
}
