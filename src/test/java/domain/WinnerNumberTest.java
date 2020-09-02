package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


import static org.assertj.core.api.Assertions.assertThat;

public class WinnerNumberTest {

    @DisplayName("당첨번호랑_몇개_일치하는지_테스트 ")
    @Test
    void 당첨번호랑_몇개_일치하는지_테스트() {
        String lastWinnerNumber = "1,2,3,4,5,9";
        String[] input = lastWinnerNumber.split(",");
        Set<Integer> onelotto = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(new WinnerNumber(input).getCountingNumber(
                new Lotto(onelotto))).isEqualTo(5);
    }

    @DisplayName("보너스 번호 찾기 테스트")
    @Test
    void findBonusTest() {
        Set<Integer> onelotto = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 9));
        String lastWinnerNumber = "1,2,3,4,5,6";
        String[] input = lastWinnerNumber.split(",");

        Lotto one = new Lotto(onelotto);

        assertThat(new WinnerNumber(input).findBonusNumber(one)).isEqualTo(9);
    }
}
