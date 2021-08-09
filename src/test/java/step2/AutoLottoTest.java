package step2;

import org.junit.jupiter.api.Test;
import step2.view.InputView;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AutoLottoTest {
    @Test
    public void 구매금액_null_빈문자() {
        //given
        InputView user = new InputView();

        //then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () ->  user.setAmount(""));

        exception = assertThrows(IllegalArgumentException.class,
                () ->  user.setAmount(null));
    }
}
