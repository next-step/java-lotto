package step2;

import org.junit.jupiter.api.Test;
import step2.model.*;

import java.util.*;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AutoLottoTest {
    @Test
    public void 구매금액_null_빈문자() {
        //given
        PurchaseAmount user = new PurchaseAmount();

        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () ->  user.getLottoCount(""));

        exception = assertThrows(IllegalArgumentException.class,
                () ->  user.getLottoCount(null));
    }

    @Test
    public void 구매금액_숫자가아님() {
        //given
        PurchaseAmount user = new PurchaseAmount();

        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () ->  user.getLottoCount("test"));
    }

    @Test
    public void 구매금액_1000미만() {
        //given
        PurchaseAmount user = new PurchaseAmount();

        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () ->  user.getLottoCount("999"));
    }

    @Test
    public void 구매갯수() {
        //given
        PurchaseAmount user = new PurchaseAmount();

        //when
        int lottoCnt = user.getLottoCount("1000");

        //then
        assertThat(lottoCnt).isEqualTo(1);
    }

    @Test
    public void 로또발급_6개랜덤숫자() {
        //given
        Lotto lotto = new Lotto(new AutoLottoStrategy());

        //then
        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    public void 구매갯수만큼_로또발급() {
        //given
        LottoGroup lottoGroup = new LottoGroup(3);

        //then
        assertThat(lottoGroup.getLottoResult().size()).isEqualTo(3);
    }
    
    @Test
    public void 당첨번호_null_빈문자() {
        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new WinningNumber(""));

        exception = assertThrows(IllegalArgumentException.class,
                () ->  new WinningNumber(null));
    }

    @Test
    public void 당첨번호_6개미만() {
        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new WinningNumber("1,2,3,4,5"));
    }

    @Test
    public void 당첨번호_문자열() {
        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new WinningNumber("test;td,1,2,dl,kk"));
    }

    @Test
    public void 당첨번호_중복() {
        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () ->  new WinningNumber("1,2,3,4,6,6"));
    }

    @Test
    public void 당첨번호_빈값() {
        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new WinningNumber("1,2,3,4,5, "));
    }

    @Test
    public void 당첨번호_범위_밖() {
        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new WinningNumber("1,2,3,4,5,100"));
    }

    @Test
    public void 당첨번호() {
        //given
        WinningNumber user = new WinningNumber("1,2,3,4,5,6");
        List<Integer> expected = Arrays.asList(1,2,3,4,5,6);

        //then
        assertEquals(user.getWinningNumbers(), expected);
    }

    @Test
    public void 당첨확인_보너스_포함() {
        //given
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(11,22,33,4,5,6))); //5등
        lottoList.add(new Lotto(Arrays.asList(11,22,3,4,5,6))); //4등
        lottoList.add(new Lotto(Arrays.asList(11,2,3,4,5,6))); //3등
        lottoList.add(new Lotto(Arrays.asList(7,2,3,4,5,6))); //2등
        lottoList.add(new Lotto(Arrays.asList(1,2,3,4,5,6))); //1등
        lottoList.add(new Lotto(Arrays.asList(8,9,10,11,12,13))); //MISS

        LottoGroup lottoGroup = new LottoGroup(lottoList);

        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
        Bonus bonus = new Bonus("7");
        Winning winning = new Winning(winningNumber, bonus);

        //when
        WinningResult lotto = new WinningResult();
        Map<Rank, Integer> result = lotto.getResult(lottoGroup, winning);

        //then
        for (Rank rank : Rank.values()) {
            assertThat(result.get(rank)).isEqualTo(1);
        }
    }

    @Test
    public void 수익률() {
        //given
        int amount = 14000;
        Map<Rank, Integer> winningResult = new HashMap<>();
        for (Rank rank : Rank.values()) {
            winningResult.put(rank, 0);

        }
        winningResult.put(Rank.FIFTH, 1);

        //when
        WinningResult lotto = new WinningResult();
        String rate = lotto.getWinningRate(amount, winningResult);

        //then
        assertThat(rate).isEqualTo("0.35");
    }

    @Test
    public void 보너스볼_당첨() {
        //given
        WinningNumber winningNumber = new WinningNumber("1,2,3,4,5,6");
        Bonus bonus = new Bonus("7");
        Winning winning = new Winning(winningNumber, bonus);

        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,7));
        LottoGroup lottoGroup = new LottoGroup(Arrays.asList(lotto));

        //when
        WinningResult result = new WinningResult();
        Map<Rank, Integer> winningResult = result.getResult(lottoGroup, winning);

        //then
        assertThat(winningResult.get(Rank.SECOND)).isEqualTo(1);
    }

}
