package lottotest.view;

import lotto.domain.LottoGame;
import lotto.domain.LottoTicket;
import lotto.domain.WinningNumber;
import lotto.domain.enums.LottoRank;
import lotto.view.InputView;
import lotto.view.ResultView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {
    LottoGame lottogame;
    ResultView resultview;
    InputView inputView;

    @Test
    @DisplayName(value = "결과값 출력")
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
        List<Integer> winningNums = new ArrayList<>(List.of(1,2,3,4,5,6));
        int bonusNum = 7;
        WinningNumber winningNumber = new WinningNumber(winningNums, bonusNum);

        //로또번호
        ArrayList<LottoTicket> tickets = new ArrayList<>();
        ArrayList<Integer> lotto = new ArrayList<>(List.of(1,2,3,4,5,7));
        tickets.add(new LottoTicket(lotto)); // 당첨번호 5개 매치 보너스번호 매치 - 2등
        tickets.add(new LottoTicket(lotto)); // 당첨번호 5개 매치 보너스번호 매치 - 2등
        tickets.add(new LottoTicket(winningNums)); // 당첨번호 6개 매치 - 1등

        assertThat(LottoRank.getResult(winningNumber, tickets)).isEqualTo(result);
    }

}