package lottotest;

import lotto.model.WinningPrice;
import lotto.model.WinningResult;
import lotto.controller.LottoManualController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoManualTest {
    LottoManualController controller;

    @BeforeEach
    void setUp() {
        controller = new LottoManualController();
    }

    @DisplayName(value = "당첨번호를 입력하면 정수들로 나타내준다.")
    @Test
    void convert_WinningNumbers_to_Integers() {
        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            winningNumbers.add(i + 1);
        }
        assertThat(controller.convertWinningNumbersToInt("1, 2, 3, 4, 5, 6")).isEqualTo(winningNumbers);
    }

    @DisplayName(value = "당첨결과 enum 에서 당첨금액을 가져와 보여준다.")
    @Test
    void show_winningPrice() {
        assertThat(WinningPrice.FIFTHPRICE.getPrice()).isEqualTo(5000);
    }

    @DisplayName(value = "당첨결과 enum 에서 당첨횟수를 가져와 보여준다.")
    @Test
    void show_The_Number_of_Winnings() {
        WinningResult winningResult = new WinningResult();

        assertThat(winningResult.getNumberOfFifthPlace()).isEqualTo(0);
    }

    @DisplayName(value = "당첨번호와 동일한 번호가 4개이면 4등 당첨횟수가 증가한다.")
    @Test
    void add_The_Number_of_Winnings() {
        WinningResult winningResult = new WinningResult();
        winningResult.addCount(4, true);

        assertThat(winningResult.getNumberOfFourthPlace()).isEqualTo(1);
    }
}
