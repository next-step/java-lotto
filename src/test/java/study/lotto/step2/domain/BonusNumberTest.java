package study.lotto.step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BonusNumberTest {
    @Test
    @DisplayName("보너스 번호가 당첨 번호에 포함되어 있을 시, IllegalArgumentException 예외 발생")
    void bonus_number_is_included_in_the_winning_number_then_throw_IllegalArgumentException() {
        // given
        WinningLotto winningLotto = new WinningLotto(1, 2, 3, 4, 5, 6);
        LottoNumber duplicatedBonusNumber = LottoNumber.of(1);

        // when, then
        assertThatThrownBy(() -> new BonusNumber(winningLotto, duplicatedBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("보너스 번호가 당첨 번호에 포함되어 있으면 안됩니다: " + duplicatedBonusNumber);
    }

    @ParameterizedTest(name = "[{index}/2] {displayName}")
    @MethodSource("lottoAndExpectedMatchBonus")
    @DisplayName("보너스 번호 매칭 확인")
    void match_bonus(Lotto lotto, boolean expectedMatchBonus) {
        // given
        BonusNumber bonusNumber = new BonusNumber(new WinningLotto(1, 2, 3, 4, 5, 6), LottoNumber.of(7));

        // when
        boolean isMatchBonus = bonusNumber.matchBonus(lotto);

        // then
        assertThat(isMatchBonus).isEqualTo(expectedMatchBonus);
    }

    private static Stream<Arguments> lottoAndExpectedMatchBonus() {
        return Stream.of(
                Arguments.of(new Lotto(7, 8, 9, 10, 11, 12), true),
                Arguments.of(new Lotto(17, 18, 19, 20, 21, 22), false)
        );
    }
}