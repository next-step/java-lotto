package util;

import domain.LottoNumber;
import domain.Lottos;
import exception.InvalidWinningNumberException;
import exception.LottoCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import study.ValidateUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidateUtilTest {

    @DisplayName("당첨 번호와 보너스 번호가 겹치는 경우 exception 발생")
    @Test
    void validateLottoBonusNumber_invalidBonusNumber() {
        assertThatThrownBy(() -> ValidateUtil.validateLottoWinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), 1))
                .isInstanceOf(InvalidWinningNumberException.class);
    }

    @DisplayName("당첨 번호가 중복이거나 6개가 아닌 경우 exception 발생")
    @ParameterizedTest
    @MethodSource("generateData")
    void validateLottoBonusNumber_invalidWinningNumber(List<Integer> input) {
        assertThatThrownBy(() -> ValidateUtil.validateLottoWinningNumber(input, 45))
                .isInstanceOf(LottoCountException.class);
    }


    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3)),
                Arguments.of(Arrays.asList(1, 1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 1, 2, 3, 4, 5, 6)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
        );
    }
}
