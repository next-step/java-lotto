import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoManualTest {
    @DisplayName(value = "당첨번호를 입력하면 정수들로 나타내준다.")
    @Test
    void convert_WinningNumbers_to_Integers() {
        LottoManualController controller = new LottoManualController();
        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            winningNumbers.add(i + 1);
        }
        assertThat(controller.convertWinningNumbersToInt("1, 2, 3, 4, 5, 6")).isEqualTo(winningNumbers);
    }

    @DisplayName(value = "당첨결과 enum 에서 당첨금액을 가져와 보여준다.")
    @Test
    void show_winningPrice() {
        assertThat(LottoManualController.winningResult.fifth.getWinningPrice()).isEqualTo(5000);
    }

    @DisplayName(value = "당첨결과 enum 에서 당첨횟수를 가져와 보여준다.")
    @Test
    void show_The_Number_of_Winnings() {
        assertThat(LottoManualController.winningResult.fifth.getNumberOfWinnings()).isEqualTo(0);
    }

    @DisplayName(value = "당첨번호와 동일한 번호가 4개이면 4등 당첨횟수가 증가한다.")
    @Test
    void add_The_Number_of_Winnings() {
        LottoManualController.winningResult.addCount(4, true);

        assertThat(LottoManualController.winningResult.fourth.getNumberOfWinnings()).isEqualTo(1);
    }
}
