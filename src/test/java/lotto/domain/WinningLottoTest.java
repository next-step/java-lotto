package lotto.domain;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class WinningLottoTest {

    @Test
    void 우승로또는_보너스번호를_추가로_가진다() {
        List<Integer> numbers = Lists.newArrayList(1, 2, 3, 4, 5, 6);
        int bonusNumber = 45;
        WinningLotto winning = new WinningLotto(numbers, bonusNumber);
        assertAll(
                () -> assertThat(winning.numbers()).containsAll(numbers),
                () -> assertThat(winning.bonusNumber).isEqualTo(bonusNumber)
        );
    }
}
