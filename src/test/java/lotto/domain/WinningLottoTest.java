package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @Test
    void create() {
        WinningLotto lotto = new WinningLotto("1,2,3,4,5,6");
    }


    @DisplayName("로또 번호 매칭")
    @Test
    void matchWithWinningLotto() {
        Lotto lotto = Lotto.of(Arrays.asList(1,2,3,4,5,6));
        int count = lotto.match(new WinningLotto("1,2,3,4,5,10").getNumbers());
        assertThat(count).isEqualTo(5);
    }

    @DisplayName("보너 번호 매칭")
    @Test
    void bonusWithWinningLotto() {
        Lotto lotto = Lotto.of(Arrays.asList(1,2,3,4,5,6));
        boolean isBonus = lotto.isBonus(new WinningLotto("1,2,3,4,5,10","6").getBonus());
        assertThat(isBonus).isTrue();
    }

    @DisplayName("보너스 볼 당첨번호 중복 불가")
    @Test
    void validateDuplicate() {
        assertThatThrownBy(() -> {
            new WinningLotto("1,2,3,4,5,6", "6");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
