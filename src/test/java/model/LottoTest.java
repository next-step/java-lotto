package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {

    @ParameterizedTest
    @MethodSource("generateInvalidLottoNumbers")
    @DisplayName("로또 번호가 6개 아니면 에러를 반환한다.")
    public void invalidLottoNumberSize(List<Integer> numbers) {
        assertThatThrownBy(() -> new Lotto(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> generateInvalidLottoNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5))
                , Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7))
        );
    }

    @ParameterizedTest
    @MethodSource("generateValidLottoNumber")
    @DisplayName("당첨 로또 번호와 현재 번호가 전부 일치한다.")
    public void countWinningNumbers(List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        Lotto winLotto = new Lotto(numbers);
        assertEquals(lotto.countWinningNumbers(winLotto), 6);
    }

    static Stream<Arguments> generateValidLottoNumber() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6))
        );
    }
}