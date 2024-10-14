package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    @DisplayName("당첨 로또 생성")
    @Test
    void 당첨로또() {
        String[] winning = {"1", "2", "6", "4", "5", "3"};
        int bonusNumber = 7;
        WinningLotto winningLotto = new WinningLotto(new Lotto(winning), bonusNumber);
        List<Integer> lottoList = winningLotto.getWinningLotto();
        assertAll(
                () -> assertThat(lottoList).isEqualTo(List.of(1, 2, 3, 4, 5, 6)),
                () -> assertThat(bonusNumber).isEqualTo(winningLotto.getBonusNumber())
        );
    }
}
