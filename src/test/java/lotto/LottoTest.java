package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("로또는 1~45의 값만 허용 확인")
    void create() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,58));
            Lotto lotto2 = new Lotto(Arrays.asList(-1,2,3,4,5,58));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨번호 비교 후 같은 번호 갯수 확인")
    void findMatchedNumberCount() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        int matchedNumberCount = lotto.findMatchedNumberCount(new WinningLottoNumbers(new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6)), 8));

        assertThat(matchedNumberCount).isEqualTo(6);
    }

    @Test
    @DisplayName("보너스 번호도 있는지 확인")
    void checkBonusBallNumber() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        int bonusNumber = 11;

        assertThat(lotto.checkBonusBallNumber(bonusNumber)).isFalse();

        bonusNumber = 6;

        assertThat(lotto.checkBonusBallNumber(bonusNumber)).isTrue();
    }

    @Test
    @DisplayName("같은값을 입력했을경우 예외처리")
    void validation() {
        assertThatThrownBy(() -> {
            Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,5));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}