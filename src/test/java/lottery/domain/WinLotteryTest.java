package lottery.domain;

import calculator.util.Validator;
import lottery.domain.vo.LotteryNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinLotteryTest {

    @Test
    @DisplayName("로또 당첨 번호 생성 테스트")
    void winLotteryTest(){
        // Given
        final String winNumbersString = "1, 2, 3, 4, 5, 6";
        // When
        WinLottery winLottery = new WinLottery(winNumbersString);
        // Then
        assertThat(winLottery.winLottery().lotteryNumbers()).hasSize(LotteryNumbers.SIZE);
        assertThat(winLottery.winLottery().lotteryNumbers()).contains(1, 2, 3, 4, 5, 6);
    }

    @ParameterizedTest
    @ValueSource(strings = {" "})
    @DisplayName("로또 당첨 번호 빈값 실패 예외 테스트")
    void winLotteryBlankThrowExceptionTest(String input){
        assertThatThrownBy(() -> {
            new WinLottery(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 비어있으면 안됩니다.");
    }
}
