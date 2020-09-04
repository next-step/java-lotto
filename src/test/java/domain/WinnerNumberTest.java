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
        Set<LottoNo> onelotto = new HashSet<>(Arrays
                .asList(new LottoNo(1)
                        ,new LottoNo(2)
                        ,new LottoNo(3)
                        ,new LottoNo(4)
                        ,new LottoNo(5)
                        ,new LottoNo(6)));
        int bonus = 7;

        assertThat(new WinnerNumber(input,bonus).getCountingNumber(
                new Lotto(onelotto))).isEqualTo(5);
    }
}
