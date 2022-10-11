package lotto;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

import java.util.List;
import java.util.stream.Stream;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import lotto.domain.Lotto;

public class LottoTest {

    @DisplayName("맞은 로또 숫자 확인 테스트")
    @ParameterizedTest
    @MethodSource("randomNumberMatchingCase")
    void match_number_find(List<Integer> lottoNum, List<Integer> winningNum, int matchingNum) {
        Lotto lotto = new Lotto(lottoNum);
        assertThat(lotto.findMatchingCount(winningNum)).isEqualTo(matchingNum);
    }

    @DisplayName("로또 validation 테스트")
    @ParameterizedTest
    @MethodSource("exceptionNumberCase")
    void validate_lotto_number(List<Integer> lottoNum, String message) {
        assertThatThrownBy(() -> new Lotto(lottoNum)).isInstanceOf(IllegalArgumentException.class)
                                                     .hasMessageContaining(message);
    }

    static Stream<Arguments> randomNumberMatchingCase() {
        return Stream.of(
                arguments(Lists.list(5, 6, 2, 1, 7, 12), Lists.list(5, 15, 23, 45, 4, 2), 2),
                arguments(Lists.list(12, 19, 23, 1, 7, 6), Lists.list(5, 15, 23, 45, 4, 2), 1),
                arguments(Lists.list(23, 6, 12, 7, 1, 19), Lists.list(5, 15, 23, 45, 4, 2), 1)
        );
    }

    static Stream<Arguments> exceptionNumberCase() {
        return Stream.of(
                arguments(Lists.list(5, 6, 2, 0, 7, 12), "로또는 0보다 커야 합니다."),
                arguments(Lists.list(12, 19, 23, 1, 7), "로또 숫자 수는 6개여야 합니다."),
                arguments(Lists.list(100, 19, 23, 1, 7, 4), "로또 최대 값은 45입니다."),
                arguments(Lists.list(19, 19, 23, 1, 7, 4), "로또 수는 중복되면 안됩니다.")
        );
    }
}
