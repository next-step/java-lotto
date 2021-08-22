package step2;

import org.junit.jupiter.api.Test;
import step2.model.*;

import java.util.*;

import static org.assertj.core.api.Assertions.*;

public class WinningTest {

    @Test
    public void 당첨확인_보너스_포함() {
        //given
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto("11,22,33,4,5,6")); //5등
        lottoList.add(new Lotto("11,22,3,4,5,6")); //4등
        lottoList.add(new Lotto("11,2,3,4,5,6")); //3등
        lottoList.add(new Lotto("7,2,3,4,5,6")); //2등
        lottoList.add(new Lotto("1,2,3,4,5,6")); //1등
        lottoList.add(new Lotto("8,9,10,11,12,13")); //MISS

        LottoGroup lottoGroup = new LottoGroup(lottoList);

        Lotto winningNumber = new Lotto("1,2,3,4,5,6");
        Bonus bonus = new Bonus(winningNumber, "7");
        Winning winning = new Winning(winningNumber, bonus);

        //when
        Result winningResult = new Result();
        Map<Rank, Integer> result = winningResult.getResult(lottoGroup, winning);

        //then
        for (Rank rank : Rank.values()) {
            assertThat(result.get(rank)).isEqualTo(1);
        }
    }

    @Test
    public void 수익률() {
        //given
        PurchaseAmount amount = new PurchaseAmount("14500");
        Map<Rank, Integer> winningResult = new HashMap<>();
        for (Rank rank : Rank.values()) {
            winningResult.put(rank, 0);

        }
        winningResult.put(Rank.FIFTH, 1);

        //when
        Result result = new Result();
        String rate = result.getWinningRate(amount, winningResult);

        //then
        assertThat(rate).isEqualTo("0.35");
    }

    @Test
    public void 보너스볼_중복() {
        //given
        Lotto winningNumber = new Lotto("1,2,3,4,5,6");

        //then
        assertThatThrownBy(() -> new Bonus(winningNumber, "6"))
                        .isInstanceOf(IllegalArgumentException.class);
    }



}
