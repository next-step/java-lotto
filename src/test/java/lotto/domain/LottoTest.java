package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;


import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    private static final Lotto WINNING_LOTTO =
            new Lotto(List.of(1, 2, 3, 4, 5, 6));

    private static final int BONUS_NUMBER = 7;

    @ParameterizedTest(name = "로또는 중복 없이 1 ~ 45의 숫자 6개를 가진다.")
    @MethodSource("provideInvalidLottoNumbers")
    void validation(List<Integer> invalidNumbers) {
        assertThatThrownBy(() -> new Lotto(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<List<Integer>> provideInvalidLottoNumbers() {
        return Stream.of(
                List.of(1),
                List.of(1, 2, 3, 4, 5, 6, 7),
                List.of(0, 2, 3, 4, 5, 6),
                List.of(1, 2, 3, 4, 5, 46),
                List.of(1, 1, 2, 3, 4, 5)
        );
    }

    @DisplayName("추가 번호는 1 ~ 45 사이의 값이면서 로또 번호와 중복되지 않아야한다.")
    @Test
    void validateBonusNumber() {
        Lotto.validateBonusNumber(WINNING_LOTTO, BONUS_NUMBER);
        assertThatNoException();
    }

    @ParameterizedTest(name = "추가 번호는 1 ~ 45 사이의 값이면서 로또 번호와 중복되지 않아야한다.")
    @ValueSource(ints = {0, 6, 46})
    void validateBonusNumber_Fail(int invalidBonusNumber) {
        assertThatThrownBy(() -> Lotto.validateBonusNumber(WINNING_LOTTO, invalidBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
