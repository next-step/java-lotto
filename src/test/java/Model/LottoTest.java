package Model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {

    @Test
    @DisplayName("당첨 금액 테스트")
    void sumLotto() {
        /*winnerRule
         *3개 일치 (5000원)
         *4개 일치 (50000원)
         *5개 일치 (1500000원)
         *6개 일치 (2000000000원)
         */

        //given
        int count = 4;
        Lotto[] lottos = new Lotto[count];
        lottos[0] = new Lotto();
        lottos[0].addLotto(new ArrayList<>(Arrays.asList(8, 21, 23, 41, 42, 43))); //2개일치
        lottos[1] = new Lotto();
        lottos[1].addLotto(new ArrayList<>(Arrays.asList(3, 5, 11, 16, 32, 38))); //1개일치
        lottos[2] = new Lotto();
        lottos[2].addLotto(new ArrayList<>(Arrays.asList(7, 11, 16, 35, 36, 44))); //1개일치
        lottos[3] = new Lotto();
        lottos[3].addLotto(new ArrayList<>(Arrays.asList(1, 8, 11, 31, 41, 42))); //5개일치

        WinngNum winngNum = new WinngNum(new ArrayList<>(Arrays.asList(1, 8, 11, 31, 41, 44)));

        WinnerRule winnerRule = new WinnerRule();

        //when
        int sum = 0;
        for (Lotto lotto : lottos) {
            sum += winnerRule.getWinnerPrice(lotto.getLotto(), winngNum.getWinngNum());
        }

        //then
        int expected = 1500000;
        int actual = sum;
        assertEquals(expected, sum);

    }
}