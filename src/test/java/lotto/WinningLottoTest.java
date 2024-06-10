package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {

    @DisplayName("당첨 로또는 6개의 당첨 번호와 1개의 보너스 번호가 있다")
    @Test
    void lottoNumbers(){
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;
        WinningLotto lotto = new WinningLotto(numbers, bonus);
        assertThat(lotto.getNumbers()).isEqualTo(numbers);
        assertThat(lotto.getBonus()).isEqualTo(bonus);
    }

    @DisplayName("당첨 로또는 6개의 당첨 번호와 1개의 보너스 번호는 중복되면 예외가 발생한다")
    @Test
    void notDuplicateNumbers(){
        Set<Integer> numbers = Set.of(1, 2, 3, 4, 5, 6);
        int bonus = 6;
        assertThatIllegalArgumentException().isThrownBy(() -> new WinningLotto(numbers, bonus));
    }


}