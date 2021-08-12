package step2;

import org.junit.jupiter.api.Test;
import step2.model.*;
import step2.view.InputView;

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
        Lotto lotto = new Lotto();

        //when
        List<Integer> numbers = lotto.getNumbers(new AutoLottoStrategy());

        //then
        assertThat(numbers.size()).isEqualTo(6);
    }

    @Test
    public void 구매갯수만큼_로또발급() {
        //given
        Lotto lotto = new Lotto();

        //when
        List<List<Integer>> lottoList = lotto.getLotto(3);

        //then
        assertThat(lottoList.size()).isEqualTo(3);
    }
    
    @Test
    public void 당첨번호_null_빈문자() {
        //given
        WinningNumber user = new WinningNumber();

        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () ->  user.getWinningNumbers(""));

        exception = assertThrows(IllegalArgumentException.class,
                () ->  user.getWinningNumbers(null));
    }

    @Test
    public void 당첨번호_6개미만() {
        //given
        WinningNumber user = new WinningNumber();

        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () ->  user.getWinningNumbers("1,2,3,4,5"));
    }

    @Test
    public void 당첨번호_문자열() {
        //given
        WinningNumber user = new WinningNumber();

        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () ->  user.getWinningNumbers("test;td,1,2,dl,kk"));
    }

    @Test
    public void 당첨번호_중복() {
        //given
        WinningNumber user = new WinningNumber();

        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () ->  user.getWinningNumbers("1,2,3,5,5,6"));
    }

    @Test
    public void 당첨번호_빈값() {
        //given
        WinningNumber user = new WinningNumber();

        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () ->  user.getWinningNumbers("1,2,3,5,5, "));

    }

    @Test
    public void 당첨번호() {
        //given
        WinningNumber user = new WinningNumber();
        List<Integer> expected = Arrays.asList(1,2,3,4,5,6);

        //when
        List<Integer> winningNo = user.getWinningNumbers("1,2,3,4,5,6");

        //then
        assertEquals(winningNo, expected);
    }

    @Test
    public void 당첨확인() {
        //given
        List<Integer> winningNoList = Arrays.asList(1,2,3,4,5,6);
        List<List<Integer>> lottoList = new ArrayList<>();
        lottoList.add(Arrays.asList(11,22,33,4,5,6)); //3개당첨
        lottoList.add(Arrays.asList(11,22,3,4,5,6)); //4개당첨
        lottoList.add(Arrays.asList(11,2,3,4,5,6)); //5개당첨
        lottoList.add(Arrays.asList(1,2,3,4,5,6)); //6개당첨

        //when
        WinningResult lotto = new WinningResult();
        Map<Integer, Integer> result = lotto.getWinningResult(lottoList, winningNoList);

        //then
        assertThat(result.get(3)).isEqualTo(1);
        assertThat(result.get(4)).isEqualTo(1);
        assertThat(result.get(5)).isEqualTo(1);
        assertThat(result.get(6)).isEqualTo(1);
    }

    @Test
    public void 수익률() {
        //given
        int amount = 14000;
        Map<Integer, Integer> winningResult = new HashMap<>();
        winningResult.put(3, 1);
        winningResult.put(4, 0);
        winningResult.put(5, 0);
        winningResult.put(6, 0);

        //when
        WinningResult lotto = new WinningResult();
        String rate = lotto.getWinningRate(amount, winningResult);

        //then
        assertThat(rate).isEqualTo("0.35");
    }

}
