package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class BonusBallTest {

    @ParameterizedTest
    @MethodSource("provideLottoNumbersAndBonusBall")
    @DisplayName("성공 - 보너스 볼이 존재하는지 알 수 있다.")
    void success_not_range_lotto_number(List<Integer> lottoNumbers, int bonusBall, boolean hasBonusBall) {
        assertThat(new BonusBall(bonusBall).containsBonusBall(lottoNumbers)).isEqualTo(hasBonusBall);
    }

    private static Stream<Arguments> provideLottoNumbersAndBonusBall() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 3, true),
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 7, false)
        );
    }

}
