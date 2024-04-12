package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class WinningLottoTest {

    @DisplayName("로또 당첨번호와 2등 보너스 번호는 중복될 경우 exception")
    @Test
    void duplicateWithBonus() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);
        int bonusNumber = 6;
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningLotto(lotto, bonusNumber));
    }
}
