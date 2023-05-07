package study.lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BonusNumberTest {
    @ParameterizedTest(name = "[{index}/2] {displayName}")
    @MethodSource("lottoAndExpectedMatchBonus")
    @DisplayName("보너스 번호 매칭 확인")
    void match_bonus(Lotto lotto, boolean expectedMatchBonus) {
        // given
        BonusNumber bonusNumber = new BonusNumber(1);

        // when
        boolean isMatchBonus = bonusNumber.matchBonus(lotto);

        // then
        assertThat(isMatchBonus).isEqualTo(expectedMatchBonus);
    }

    private static Stream<Arguments> lottoAndExpectedMatchBonus() {
        return Stream.of(
                Arguments.of(new Lotto(1, 2, 3, 4, 5, 6), true),
                Arguments.of(new Lotto(11, 12, 13, 14, 15, 16), false)
        );
    }
}