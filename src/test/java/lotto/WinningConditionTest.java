package lotto;

import lotto.domain.WinningCondition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningConditionTest {

    private WinningCondition winningCondition;

    @BeforeEach
    public void setUp() {
        winningCondition = new WinningCondition(Arrays.asList(1,2,3,4,5,6), 7);
    }

    @Test
    @DisplayName("당첨번호를 반환하는지 확인")
    public void get_winning_numbers() {
        List<Integer> winningNumbers = winningCondition.getWinningNumbers();
        assertThat(winningNumbers).isEqualTo(Arrays.asList(1,2,3,4,5,6));
    }

    @Test
    @DisplayName("보너스 번를 반환하는지 확인")
    public void get_bonus_number() {
        int bonusNumber = winningCondition.getBonusNumber();
        assertThat(bonusNumber).isEqualTo(7);
    }
}
