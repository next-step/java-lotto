package lotto;

import lotto.controller.LottoController;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;

public class LottoControllerTest {


    @ParameterizedTest
    @ValueSource(strings = {"1", "1, 2, 3", "1, 2, 3, 4, 5, 46"})
    public void 지난_로또_결과_입력_실패(String input) throws Exception {
        LottoController lottoController = new LottoController();
        Method getWinnerNumbers = getGetWinnerNumbers(lottoController);
        try {
            getWinnerNumbers.invoke(lottoController, input);
            fail("지난_로또_결과_입력_실패 테스트 실패");
        } catch (InvocationTargetException e) {
            assertThat(e.getCause()).isInstanceOf(IllegalArgumentException.class);
        }
    }


    @ParameterizedTest
    @ValueSource(strings = {"45,44,43,42,41,40", "1, 2, 3, 4,5 , 6"})
    public void 지난_로또_결과_입력_성공(String input) throws Exception {
        LottoController lottoController = new LottoController();
        Method getWinnerNumbers = getGetWinnerNumbers(lottoController);
        getWinnerNumbers.invoke(lottoController, input);
    }


    private Method getGetWinnerNumbers(LottoController lottoController) throws Exception {
        Method getWinnerNumbers = lottoController.getClass().getDeclaredMethod("getWinnerNumbers", String.class);
        getWinnerNumbers.setAccessible(true);

        return getWinnerNumbers;
    }
}
