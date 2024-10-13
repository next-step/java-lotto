package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static lotto.domain.LottoRank.FOURTH;
import static lotto.domain.LottoRank.SECOND;
import static lotto.domain.LottoRank.THIRD;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {
    @DisplayName("로또등수")
    @Test
    void 로또등수() {
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 5, 7, 8, 9, 11));
        Lotto lotto = new Lotto(lottoNumbers);
        List<Integer> winningLottoNumbers = new ArrayList<>(Arrays.asList(1, 5, 7, 8, 9, 10));
        int bonusNumber = 13;
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningLottoNumbers), bonusNumber);
        assertThat(lotto.getLottoResult(winningLotto)).isEqualTo(THIRD);
    }

    @DisplayName("로또2등")
    @Test
    void 로또2등() {
        List<Integer> lottoNumbers = new ArrayList<>(Arrays.asList(1, 5, 7, 8, 9, 11));
        Lotto lotto = new Lotto(lottoNumbers);
        List<Integer> winningLottoNumbers = new ArrayList<>(Arrays.asList(1, 5, 7, 9, 11, 12));
        int bonusNumber = 8;
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningLottoNumbers), bonusNumber);
        assertThat(lotto.getLottoResult(winningLotto)).isEqualTo(SECOND);
    }
}
