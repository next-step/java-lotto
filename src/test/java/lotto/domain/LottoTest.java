package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("생성 확인")
    @Test
    void 생성_확인() {
        // given
        List<String> numbers = Arrays.asList("1", "2", "3", "4", "5", "6");

        // when
        Lotto lotto = new Lotto(numbers);

        // then
        assertThat(lotto.get()).isEqualTo(numbers);
    }

    @DisplayName("번호 몇개 맞았는지 확인")
    @Test
    void matchWinningNumber() {
        // given
        Lotto lotto = new Lotto(Arrays.asList("1", "2", "3", "4", "5", "6"));
        List<String> winnigNumbers = Arrays.asList("1", "2", "3", "4", "5", "7");

        // when
        int matchNumber = lotto.matchNumber(winnigNumbers);

        // then
        assertThat(matchNumber).isEqualTo(5);
    }

    @DisplayName("보너스 번호 맞았는지 확인 - ture")
    @Test
    void containsBonusNumber_true() {
        // given
        Lotto lotto = new Lotto(Arrays.asList("1", "2", "3", "4", "5", "6"));

        // when
        boolean isBonus = lotto.containsBonusNumber("5");

        // then
        assertThat(isBonus).isEqualTo(true);
    }

    @DisplayName("보너스 번호 맞았는지 확인 - false")
    @Test
    void containsBonusNumber_false() {
        // given
        Lotto lotto = new Lotto(Arrays.asList("1", "2", "3", "4", "5", "6"));

        // when
        boolean isBonus = lotto.containsBonusNumber("7");

        // then
        assertThat(isBonus).isEqualTo(false);
    }
}
