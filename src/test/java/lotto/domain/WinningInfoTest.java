package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinningInfoTest {

    @Test
    @DisplayName("4등 당첨금 확인 Test")
    void totalWinningMoney() {
        LottoNumbers pickedNumbers = new LottoNumbers(Arrays.asList(1,2,3,11,12,13));
        PickedLottoNumbers pickedLottoNumbers = new PickedLottoNumbers();
        pickedLottoNumbers.add(pickedNumbers);

        LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(1,2,3,4,5,6));
        WinningInfo winningInfo = WinningInfo.of(pickedLottoNumbers, winningNumbers);

        int winningMoney = winningInfo.totalWinningMoney();

        assertThat(winningMoney).isEqualTo(5000);
    }
}