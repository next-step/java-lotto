package lottotest.domain;

import lotto.domain.LottoGame;
import lotto.domain.LottoTicket;
import lotto.view.ResultView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LottoGameTest {

    LottoGame lottogame;
    ResultView resultview;

    @BeforeEach
    public void SetUp(){
        lottogame = new LottoGame();
    }

    @Test
    @DisplayName("랜덤로또번호")
    public void getLottoNumber(){
        System.out.println(lottogame.getLottoNumber());
    }

    @Test
    @DisplayName("로또게임 n회 사기")
    public void buyLottoGame(){
        lottogame.buyLottoGame(5);
    }

    @Test
    @DisplayName("로또랭킹")
    public void getRanking(){
        int matchCnt = 3;
        boolean isBonusMatch = false;

        System.out.println(lottogame.getRanking(matchCnt, isBonusMatch));
    }

    @Test
    @DisplayName("로또결과 출력")
    public void getResult(){
        resultview = new ResultView();

        ArrayList<Integer> Numbers = new ArrayList<>();
        Numbers.add(1);
        Numbers.add(2);
        Numbers.add(3);
        Numbers.add(4);
        Numbers.add(5);
        Numbers.add(6);

        ArrayList<Integer> winningNumber1 = new ArrayList<>();
        winningNumber1.add(1);
        winningNumber1.add(2);
        winningNumber1.add(3);
        winningNumber1.add(7);
        winningNumber1.add(8);
        winningNumber1.add(9);

        lottogame.tickets.add(new LottoTicket(Numbers));
        lottogame.setWinningNumbers(winningNumber1);
        lottogame.setBonusNumber(1);
        lottogame.setGameInit(1000);

        resultview.printResult(lottogame.getResult(), lottogame.calculateRate());

    }

}
