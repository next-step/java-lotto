package lotto.domain;

import lotto.dto.WinningInfoDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class WinningTest {
    @DisplayName("당첨개수에 해당하는 당첨 금액을 리턴")
    @ParameterizedTest
    @CsvSource(value = {"6:false:2000000000", "5:true:30000000","5:false:1500000", "4:false:50000", "3:false:5000"}, delimiter = ':')
    void 당첨_금액(int correctCount, boolean bonusCorrect, int expectedWinningAmount) {
        Amount result = Winning.winningAmount(correctCount, bonusCorrect);

        assertThat(result).isEqualTo(Amount.of(expectedWinningAmount));
    }

    @DisplayName("enum에 유효하지 않은 값을 전달할경우")
    @Test
    void 유효하지않은_값() {
        int correctCount = 9;

        Amount result = Winning.winningAmount(correctCount, false);

        assertThat(result).isEqualTo(Amount.of(0));
    }

    @DisplayName("당첨정보와 해당 등수가 일치하는지 여부를 리턴")
    @Test
    void 등수_확인() {
        WinningInfoDTO winningInfoDTO = new WinningInfoDTO(5, true, Amount.of(30_000_000));
        assertThat(Winning.isMatched(winningInfoDTO, Winning.FIRST)).isFalse();
        assertThat(Winning.isMatched(winningInfoDTO, Winning.SECOND)).isTrue();
        assertThat(Winning.isMatched(winningInfoDTO, Winning.THIRD)).isFalse();
        assertThat(Winning.isMatched(winningInfoDTO, Winning.FOURTH)).isFalse();
        assertThat(Winning.isMatched(winningInfoDTO, Winning.FIFTH)).isFalse();
    }
}