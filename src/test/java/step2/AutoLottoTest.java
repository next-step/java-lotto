package step2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import step2.model.AutoLottoStrategy;
import step2.model.Lotto;
import step2.view.InputView;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AutoLottoTest {
    @Test
    public void 구매금액_null_빈문자() {
        //given
        InputView user = new InputView();

        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () ->  user.getAmount(""));

        exception = assertThrows(IllegalArgumentException.class,
                () ->  user.getAmount(null));
    }

    @Test
    public void 구매금액_숫자가아님() {
        //given
        InputView user = new InputView();

        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () ->  user.getAmount("test"));
    }

    @Test
    public void 구매금액_1000미만() {
        //given
        InputView user = new InputView();

        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () ->  user.getAmount("999"));
    }

    @Test
    public void 구매갯수() {
        //given
        InputView user = new InputView();

        //when
        int lottoCnt = user.getAmount("1000");

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
        InputView user = new InputView();

        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () ->  user.getWinningNo(""));

        exception = assertThrows(IllegalArgumentException.class,
                () ->  user.getWinningNo(null));
    }

}
