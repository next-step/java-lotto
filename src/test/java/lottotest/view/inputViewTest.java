package lottotest.view;


import lotto.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class inputViewTest {
    private InputView inputview;

    @BeforeEach
    void setUp() {
        inputview = new InputView();
    }

    public static InputStream getInput(String input){
        return new ByteArrayInputStream(input.getBytes());
    }

    @ParameterizedTest
    @DisplayName("로또금액 입력")
    @ValueSource(strings = {"16000"})
    void lottoInputTest(String input){
        InputStream in = getInput(input);
        System.setIn(in);

        System.out.println(inputview.inputMoney());
    }

    @ParameterizedTest
    @DisplayName("당첨 보너스 번호")
    @ValueSource(strings = {"1"})
    public void inputBonusNum(String input){
        InputStream in = getInput(input);
        System.setIn(in);

        System.out.println(inputview.inputBonusNum());
    }

    @ParameterizedTest
    @DisplayName("당첨 번호")
    @ValueSource(strings = {"1,2,3,4,5,6"})
    public void inputWinningNum(String input){
        InputStream in = getInput(input);
        System.setIn(in);

        System.out.println(inputview.inputWinningNum());
    }
}
