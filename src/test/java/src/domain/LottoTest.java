package src.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    void 다른_로또와_몇개의_숫자가_매치되는지_확인할_수_있다() {
        // given
        Lotto gameLotto = Lotto.of(
                Set.of(GameNumber.of(1), GameNumber.of(2), GameNumber.of(3),
                        GameNumber.of(4), GameNumber.of(5), GameNumber.of(6))
        );
        Lotto matchLotto = Lotto.of(Set.of(GameNumber.of(4), GameNumber.of(5), GameNumber.of(6),
                GameNumber.of(7), GameNumber.of(8), GameNumber.of(9)));
        int expectedMatchCount = 3;

        // when
        int matchCount = gameLotto.matchCount(matchLotto);

        // then
        assertThat(matchCount).isEqualTo(expectedMatchCount);
    }

    @ParameterizedTest
    @CsvSource(value = {"1: true", "45:false"}, delimiter = ':')
    void 보너스_볼이_매치_여부를_확인할_수_있다(int number, boolean expectedMatchBonus) {
        // given
        Lotto gameLotto = Lotto.of(
                Set.of(GameNumber.of(1), GameNumber.of(2), GameNumber.of(3),
                        GameNumber.of(4), GameNumber.of(5), GameNumber.of(6))
        );
        GameNumber bonusNumber = GameNumber.of(number);

        // when
        boolean matchBonus = gameLotto.matchBonus(bonusNumber);
        // then
        assertThat(matchBonus).isEqualTo(expectedMatchBonus);
    }

    @Test
    void 로또는_6개의_게임번호가_아닐시_생성할_수_없다() {
        // given
        Set<GameNumber> numbers = Set.of(GameNumber.of(1), GameNumber.of(2), GameNumber.of(3),
                GameNumber.of(4), GameNumber.of(5));

        // when then
        assertThatThrownBy(() -> Lotto.of(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또의 번호는 6자리입니다.");
    }
}
