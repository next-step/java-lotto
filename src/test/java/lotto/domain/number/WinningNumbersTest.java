package lotto.domain.number;

import static lotto.domain.number.LottoNumbers.LOTTO_NUMBERS_SIZE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.exception.InvalidLottoNumberException;
import lotto.domain.exception.InvalidLottoNumbersSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumbersTest {

    @Test
    @DisplayName("지난주 당첨 번호 생성.")
    void generate_winning_numbers() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThat(winningNumbers.getNumbers()).hasSize(LOTTO_NUMBERS_SIZE);
    }

    @Test
    @DisplayName("정해진 숫자 수랑 다르게 당첨 번호를 생성 시도 시 예외 발생.")
    void fail_to_get_winning_numbers_by_invalid_size() {
        assertThatExceptionOfType(InvalidLottoNumbersSizeException.class)
                .isThrownBy(() -> new WinningNumbers(List.of(1, 2, 3, 4, 5, 6, 7)));
    }

    @ParameterizedTest
    @MethodSource("getMatchTestArguments")
    @DisplayName("주어진 티켓에서 당첨 번호 일치 개수 확인.")
    void count_matching_number(WinningNumbers winningNumbers, int number, boolean expected) {
        assertThat(winningNumbers.contain(number)).isEqualTo(expected);
    }

    @Test
    @DisplayName("정해진 범위를 넘어가는 숫자가 포함된 당첨 번호 생성 시도 시 예외 발생.")
    void fail_to_get_winning_numbers_by_invalid_number() {
        assertThatExceptionOfType(InvalidLottoNumberException.class)
                .isThrownBy(() -> new WinningNumbers(List.of(111, 2, 3, 4, 5, 7)));
    }

    private static Stream<Arguments> getMatchTestArguments() {
        return Stream.of(
                Arguments.arguments(
                        new WinningNumbers(List.of(3, 8, 12, 14, 15, 17)),
                        15,
                        true
                ),
                Arguments.arguments(
                        new WinningNumbers(List.of(3, 8, 12, 14, 15, 17)),
                        17,
                        true
                ),
                Arguments.arguments(
                        new WinningNumbers(List.of(3, 8, 12, 14, 15, 17)),
                        19,
                        false
                )
        );
    }

}
