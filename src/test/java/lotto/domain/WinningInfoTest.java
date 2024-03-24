package lotto.domain;

import lotto.fixture.LottoNumbersFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinningInfoTest {

    @ParameterizedTest
    @DisplayName("로또 번호에 따라 정해진 로또 번호와 비교 후 로또 당첨금을 확인할 수 있다.")
    @EnumSource(LottoNumbersFixture.class)
    void fourWinningMoney(LottoNumbersFixture fixture) {
        WinningInfo winningInfo = WinningInfo.of(fixture.getPickedNumbers(), fixture.getWinningNumbers());

        int winningMoney = winningInfo.totalWinningMoney();

        assertThat(winningMoney).isEqualTo(fixture.getRank().getWinningMoney());
    }
}