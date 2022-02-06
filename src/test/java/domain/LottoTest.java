package domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName("로또 번호가 총 몇 개가 일치하는지 테스트")
    void checkLottoNumbers() {
        //given
        Lotto lotto = new Lotto(() -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

        //when
        int correctNumberCount = lotto.countMatch(new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7, 8)));

        //then
        assertThat(correctNumberCount).isEqualTo(4);
    }

    @Test
    @DisplayName("로또 번호가 하나도 일치하지 않는지 테스트")
    void checkNonLottoNumbers() {
        //given
        Lotto lotto = new Lotto(() -> new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));

        //when
        int correctNumberCount = lotto.countMatch(new ArrayList<>(Arrays.asList(7, 8, 9, 10, 11, 12)));

        //then
        assertThat(correctNumberCount).isEqualTo(0);
    }
}