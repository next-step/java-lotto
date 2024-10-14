package lotto.domain;

import static lotto.domain.LottoRank.SECOND;
import static lotto.domain.LottoRank.THIRD;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.ArrayList;
import java.util.Arrays;
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

    @DisplayName("로또등수")
    @Test
    void 로또등수() {
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 5, 7, 8, 9, 11));
        Lotto lotto = new Lotto(lottoNumbers);
        List<Integer> winningLottoNumbers = new ArrayList<>(Arrays.asList(1, 5, 7, 8, 9, 10));
        int bonusNumber = 13;
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningLottoNumbers), bonusNumber);
        assertThat(winningLotto.getLottoResult(lotto)).isEqualTo(THIRD);
    }

    @DisplayName("로또2등")
    @Test
    void 로또2등() {
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 5, 7, 8, 9, 11));
        Lotto lotto = new Lotto(lottoNumbers);
        List<Integer> winningLottoNumbers = new ArrayList<>(Arrays.asList(1, 5, 7, 9, 11, 12));
        int bonusNumber = 8;
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningLottoNumbers), bonusNumber);
        assertThat(winningLotto.getLottoResult(lotto)).isEqualTo(SECOND);
    }
}
