package lotto;

import lotto.domain.Win;
import lotto.enums.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinTest {
    Win win;
    Set<Integer> firstPlaceNumbers;
    Set<Integer> secondPlaceNumbers;
    Set<Integer> thirdPlaceNumbers;
    Set<Integer> fourthPlaceNumbers;
    Set<Integer> bonusPlaceNumbers;

    @BeforeEach
    void setUp() {
        win = new Win(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        firstPlaceNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        secondPlaceNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 9));
        thirdPlaceNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 8, 9));
        fourthPlaceNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 10, 8, 9));
        bonusPlaceNumbers = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 7));
    }

    @Test
    void 당첨확인_테스트() {

        assertThat(win.getRank(firstPlaceNumbers)).isEqualTo(Rank.FIRST_PLACE);
        assertThat(win.getRank(secondPlaceNumbers)).isEqualTo(Rank.SECOND_PLACE);
        assertThat(win.getRank(thirdPlaceNumbers)).isEqualTo(Rank.THIRD_PLACE);
        assertThat(win.getRank(fourthPlaceNumbers)).isEqualTo(Rank.FOURTH_PLACE);
        assertThat(win.getRank(bonusPlaceNumbers)).isEqualTo(Rank.BONUS_PLACE);

    }
}
