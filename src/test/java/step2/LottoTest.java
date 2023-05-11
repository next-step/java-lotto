/*
 * LottoTest.java
 *
 * version 1.0
 *
 * 2023/05/01
 *
 * This software is the confidential and proprietary information of Nayoung Kim
 */

package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    AutoLotto autoLotto = null;

    @BeforeEach
    public void AutoLotto(){
        autoLotto = new AutoLotto();
    }

    @Test
    @DisplayName("로또 구입금액 유효성 검증")
    public void testBuyLottoMoneyValidation(){
        assertThat(autoLotto.validateMoney(1000)).isEqualTo(true);
        assertThat(autoLotto.validateMoney(14000)).isEqualTo(true);
        assertThat(autoLotto.validateMoney(5100)).isEqualTo(false);
    }

    @Test
    @DisplayName("로또 구입금액이 0인지 확인")
    public void testMoneyIsZero(){
        assertThat(autoLotto.isMoneyZero(1000)).isEqualTo(false);
        assertThat(autoLotto.isMoneyZero(0)).isEqualTo(true);
    }

    @Test
    @DisplayName("로또 몇 장 샀는지 계산")
    public void calculateLottoCnt(){
        assertThat(autoLotto.calculateLottoCnt(20000)).isEqualTo(20);
        assertThat(autoLotto.calculateLottoCnt(13000)).isEqualTo(13);
        assertThat(autoLotto.calculateLottoCnt(13000)).isEqualTo(13);
    }

     /*
     // 이거 구현해야됨
    @Test
    @DisplayName("장 수에 맞게 로또 자동생성")
    public void makeLotto(){
        // random 함수를 쓰는데 어떻게 test를 하지?
        assertThat(autoLotto.makeLottos(6))
    }
     */

    @Test
    @DisplayName("자동생성한 로또 정렬")
    public void testSortAutoLotto(){
        assertThat(autoLotto.sortLotto("5,7,20,2,10,13")).isEqualTo("2, 5, 7, 10, 13, 20");
        assertThat(autoLotto.sortLotto("21,41,43,23,42,8")).isEqualTo("8, 21, 23, 41, 42, 43");
    }

    @Test
    @DisplayName("당첨 번호 유효성 검증")
    public void testValidateWinningNumbers(){
        assertThat(autoLotto.validateWinningNumbers("1,2,3,4,5,6")).isEqualTo(true);
        assertThat(autoLotto.validateWinningNumbers("1,2,3,5")).isEqualTo(false);
    }

    @Test
    @DisplayName("")
    public void testMakeLottos(){

    }

    private 

    @Test
    @DisplayName("로또 1장 당 특정 숫자가 있는지 확인")
    public void testConfirmNumByOneLotto(){
        assertThat(autoLotto.compareWinningNumberWithLotto(2, "2,5,7,10,13,20", 0)).isEqualTo(1);
        assertThat(autoLotto.compareWinningNumberWithLotto(4, "2,5,7,10,13,20", 0)).isEqualTo(0);
    }

    @Test
    @DisplayName("로또 1장 당 당첨 숫자 개수 확인")
    public void testHowManyWinningNumbersInLotto(){
        assertThat(autoLotto.compareAnswerAtOneLotto("2,5", "2,5,7,10,13,20")).isEqualTo(2);
        assertThat(autoLotto.compareAnswerAtOneLotto("3", "2,5,7,10,13,20")).isEqualTo(0);
        assertThat(autoLotto.compareAnswerAtOneLotto("2,5,7,10,13,20", "2,5,7,10,13,20")).isEqualTo(6);
    }

    @Test
    @DisplayName("로또 각 장마다 몇 개의 숫자를 맞혔는지 확인")
    public void testLotto(){
        ArrayList<String> list = new ArrayList<String>();
        list.add("8, 21, 23, 41, 42, 43");
        list.add("3, 5, 11, 16, 32, 38");
        list.add("7, 11, 16, 35, 36, 44");

        assertThat(autoLotto.compareAllLotto("1,3,5,7,9,11", list)).containsExactly(0, 3, 2);
    }

    @Test
    @DisplayName("수익률 계산")
    public void testCalculateEarningRate(){
        assertThat(autoLotto.calculateEarningRate(14, 5000)).isEqualTo("0.35");
    }
}
