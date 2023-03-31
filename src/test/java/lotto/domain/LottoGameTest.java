package lotto.domain;

import lotto.domain.LottoGame;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumber;
import lotto.domain.enums.LottoRank;
import lotto.view.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static lotto.domain.enums.LottoRank.FIRST;
import static lotto.domain.enums.LottoRank.SECOND;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {

    LottoGame lottogame;
    ResultView resultview;

    @Test
    @DisplayName("로또게임 횟수 구하기")
    public void getGameCount(){
        lottogame = new LottoGame(10000,2000); //10000원 10게임을 사는지 확인
        assertThat(lottogame.getGameCount()).isEqualTo(10);
    }

    @Test
    @DisplayName("실제 구입금액 확인")
    public void getPurchaseAmount(){
        lottogame = new LottoGame(50600,2000); //50600원에서 실제 50000원만 사는지 확인
        assertThat(lottogame.getPurchasePrice()).isEqualTo(50000);
    }

    @Test
    @DisplayName("로또 n회 사기")
    public void buyLotto(){
        lottogame = new LottoGame(20000,2000); // 20000원어치 20개구매
        assertThat(lottogame.buyLotto().size()).isEqualTo(20);
    }

    @Test
    @DisplayName(value = "랭킹구하기")
    void checkRanking() {
        //6개 매치 -> 1등
        assertThat(LottoRank.findRank(6, false)).isEqualTo(FIRST);
        //5개 매치 && 보너스번호 매치 -> 2등
        assertThat(LottoRank.findRank(5, true)).isEqualTo(SECOND);
    }

    @Test
    @DisplayName(value = "결과값 구하기")
    void getResult() {

        //1등 1개, 2등 2개
        Map<LottoRank, Integer> result = new HashMap<>();
        result.put(LottoRank.FIRST, 1);
        result.put(LottoRank.SECOND, 2);
        result.put(LottoRank.THIRD, 0);
        result.put(LottoRank.FOURTH, 0);
        result.put(LottoRank.FIFTH, 0);
        result.put(LottoRank.MISS, 0);

        //당첨번호
        ArrayList<Integer> winningNums = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6));
        int bonusNum = 7;
        WinningNumber winningNumber = new WinningNumber(winningNums, bonusNum);

        //로또번호
        ArrayList<LottoTicket> tickets = new ArrayList<>();
        ArrayList<Integer> lotto = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,7));
        tickets.add(new LottoTicket(lotto)); // 당첨번호 5개 매치 보너스번호 매치 - 2등
        tickets.add(new LottoTicket(lotto)); // 당첨번호 5개 매치 보너스번호 매치 - 2등
        tickets.add(new LottoTicket(winningNums)); // 당첨번호 6개 매치 - 1등

        assertThat(LottoRank.getResult(winningNumber, tickets)).isEqualTo(result);
    }

    @Test
    @DisplayName("수익률 테스트")
    public void calculateRate(){
        lottogame = new LottoGame(10000, 2000);

        Map<LottoRank, Integer> result = new HashMap<>();
        result.put(LottoRank.FIRST, 1);
        result.put(LottoRank.SECOND, 0);
        result.put(LottoRank.THIRD, 0);
        result.put(LottoRank.FOURTH, 0);
        result.put(LottoRank.FIFTH, 0);
        result.put(LottoRank.MISS, 0);

        // 실제 구입금액 10,000원 대비 일등 당첨액 2000,000,000
        assertThat(lottogame.calculateRate(result)).isEqualTo(2000000000/10000);
    }

    @Test
    @DisplayName("로또 최종결과 출력")
    public void printResult(){

        lottogame = new LottoGame(10000,2000);
        resultview = new ResultView();

        Map<LottoRank, Integer> result = new HashMap<>();
        result.put(LottoRank.FIRST, 1);
        result.put(LottoRank.SECOND, 0);
        result.put(LottoRank.THIRD, 0);
        result.put(LottoRank.FOURTH, 0);
        result.put(LottoRank.FIFTH, 0);
        result.put(LottoRank.MISS, 0);

        resultview.printResult(result, lottogame.calculateRate(result));
    }

}