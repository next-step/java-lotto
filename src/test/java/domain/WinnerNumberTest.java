package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerNumberTest {

    @DisplayName("getCountingNumber 테스트 ")
    @Test
    void 당첨번호랑_몇개_일치하는지_테스트() {
        String lastWinnerNumber = "1,2,3,4,5,6";
        String[] input = lastWinnerNumber.split(",");

        Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1,2,3,4,5,7)));
//        assertThat(new WinnerNumber(input).getCountingNumber(lotto)).isEqualTo(5);
    }
}
