package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


import static org.assertj.core.api.Assertions.assertThat;

public class WinnerNumberTest {

    @DisplayName("getCountingNumber 테스트 ")
    @Test
    void 당첨번호랑_몇개_일치하는지_테스트() {
        String lastWinnerNumber = "1,2,3,4,5,6";
        String[] input = lastWinnerNumber.split(",");
        Set<Integer> winner = new HashSet<>(Arrays.asList(1, 2, 3, 4, 8, 9));
        Set<Integer> onelotto = new HashSet<>(Arrays.asList(1, 2, 3, 4, 8, 6));

        Lottos lottos = new Lottos();
        lottos.setWinnerNumber(new Lotto(winner));

        assertThat(lottos.getCountingNumber(new Lotto(onelotto))).isEqualTo(5);
    }
}
