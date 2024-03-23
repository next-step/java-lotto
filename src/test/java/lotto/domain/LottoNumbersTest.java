package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.domain.LottoValidator.MAX_LOTTO_NUMBER;
import static lotto.domain.LottoValidator.MIN_LOTTO_NUMBER;
import static org.assertj.core.api.Assertions.*;

public class LottoNumbersTest {

    @Test
    @DisplayName("from 호출할 때 매개변수 리스트의 size 6이 아니면 IllegalArgumentException")
    void from_list_size_exception() {
        assertThatThrownBy(() -> createLottoNumber(1, 2, 3, 4, 5)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> createLottoNumber(1, 2, 3, 4, 5, 6, 7)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("from 호출할 때 매개변수 리스트의 요소가 최솟값보다 작은 경우 IllegalArgumentException")
    void from_min_number_valid_exception() {
        int invalidNumber = MIN_LOTTO_NUMBER - 1;
        assertThatThrownBy(() -> createLottoNumber(invalidNumber, 3, 5, 10, 33, 45)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("from 호출할 때 매개변수 리스트의 요소가 최대값보다 작은 경우 IllegalArgumentException")
    void from_max_number_valid_exception() {
        int invalidNumber = MAX_LOTTO_NUMBER + 1;
        assertThatThrownBy(() -> createLottoNumber(invalidNumber, 1, 5, 10, 33, 45)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("from 호출 시 LottoNumber 생성하여 정상 반환")
    void from_success() {
        LottoNumbers lottoNumbers = createLottoNumber(1,2,3,4,5,6);

        assertThat(lottoNumbers.size()).isEqualTo(6);
    }

    @ParameterizedTest(name = "동일한 숫자 개수 : {2}")
    @MethodSource("lottoNumbersAndContainsCount")
    @DisplayName("containsCount 호출 시 넘어오는 LottoNumber와 동일한 숫자의 개수 반환")
    void containsCount(LottoNumbers lottoNumbers, LottoNumbers winnerNumber, int containsCount) {
        assertThat(lottoNumbers.containsCount(winnerNumber)).isEqualTo(containsCount);
    }

    static Stream<Arguments> lottoNumbersAndContainsCount() {
        LottoNumbers lottoNumbers = LottoNumbers.from(List.of(1, 2, 3, 4, 5, 6));
        return Stream.of(
                Arguments.arguments(lottoNumbers, createLottoNumber(1, 2, 3, 4, 5, 6), 6),
                Arguments.arguments(lottoNumbers, createLottoNumber(1, 2, 3, 4, 5, 42), 5),
                Arguments.arguments(lottoNumbers, createLottoNumber(1, 2, 3, 4, 29, 38), 4),
                Arguments.arguments(lottoNumbers, createLottoNumber(1, 2, 3, 30, 31, 32), 3)
        );
    }

    public static LottoNumbers createLottoNumber(int... numbers) {
        return Arrays.stream(numbers)
                .boxed()
                .collect(Collectors.collectingAndThen(Collectors.toList(), LottoNumbers::from));
    }
}
