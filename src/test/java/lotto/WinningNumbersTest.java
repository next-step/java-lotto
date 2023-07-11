package lotto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class WinningNumbersTest {

    @Test
    @DisplayName("당첨 번호 생성 테스트")
    void create() {

        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        Assertions.assertThatNoException()
                .isThrownBy(() -> new WinningNumbers(lottoNumbers, bonusNumber));
    }

    @Test
    @DisplayName("당첨 번호와 보너스 번호 중복 테스트")
    void validateDuplicatedBonus() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 6;

        Assertions.assertThatThrownBy(() -> new WinningNumbers(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또와 당첨 번호를 비교하여 등수를 반환 테스트")
    void match() {
        WinningNumbers winningNumbers = new WinningNumbers(List.of(1, 2, 3, 4, 5, 6), 7);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 8, 9));

        Assertions.assertThat(winningNumbers.match(lotto)).isEqualTo(LottoRank.FOURTH);
    }
}
