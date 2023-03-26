package lottotest.view;


import lotto.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InputViewTest {
    private InputView inputview;

    public static InputStream getInput(String input){
        return new ByteArrayInputStream(input.getBytes());
    }

    @BeforeEach
    void setUp() {
        inputview = new InputView();
    }

    @ParameterizedTest
    @DisplayName("구입금액 입력")
    @ValueSource(strings = {"16000"})
    void lottoInputMoney(String input){

        InputStream in = getInput(input);
        System.setIn(in);
        inputview.inputMoney();
        assertThat(inputview.getPurchasePrice()).isEqualTo(16000);
    }

    @ParameterizedTest
    @DisplayName("수동구입 횟수 체크")
    @ValueSource(strings = {"10"})
    void checkManualCount(String input){
        InputStream in = getInput(input);
        System.setIn(in);

        inputview.gameCount = 3; //총게임횟수
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {inputview.inputManualCnt();}
                ).withMessageContaining("구매할 수 있는 범위를 넘었습니다.");
    }

    @ParameterizedTest
    @DisplayName("수동구입 횟수 입력시 수동, 자동횟수 테스트")
    @ValueSource(strings = {"3"})
    void lottoManualCount(String input){
        InputStream in = getInput(input);
        System.setIn(in);

        inputview.gameCount = 10; //총게임횟수
        inputview.inputManualCnt();

        assertThat(inputview.getManualCount()).isEqualTo(3); //수동
        assertThat(inputview.getAutoCount()).isEqualTo(7); //자동
    }

    @ParameterizedTest
    @DisplayName("수동입력 확인")
    @ValueSource(strings = {"1,2,3,4,6,7"})
    void checkManualInput(String input){
        InputStream in = getInput(input);
        System.setIn(in);

        assertThat(inputview.inputWinningNum()).isEqualTo(List.of(1,2,3,4,6,7));
    }

    @ParameterizedTest
    @DisplayName("수동입력 중복번호 체크")
    @ValueSource(strings = {"1,2,3,4,6,6"})
    void checkManualDup(String input){
        InputStream in = getInput(input);
        System.setIn(in);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {inputview.inputManualNums(1);}
                ).withMessageContaining("중복된 번호를 사용할 수 없습니다.");
    }

    @ParameterizedTest
    @DisplayName("수동입력 번호정합성 체크")
    @ValueSource(strings = {"1,2,3,4,6,79"})
    void checkManualValid(String input){
        InputStream in = getInput(input);
        System.setIn(in);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {inputview.inputManualNums(1);}
                ).withMessageContaining("1~45 사이의 번호가 아닙니다.");
    }

    @ParameterizedTest
    @DisplayName("수동입력 자릿수 체크")
    @ValueSource(strings = {"1,2,3,4,6,7,9"})
    void checkManualSize(String input){
        InputStream in = getInput(input);
        System.setIn(in);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {inputview.inputManualNums(1);}
                ).withMessageContaining("로또 번호가 6자리가 아닙니다.");
    }

    @ParameterizedTest
    @DisplayName("당첨 보너스 번호")
    @ValueSource(strings = {"1"})
    public void inputBonusNum(String input){
        InputStream in = getInput(input);
        System.setIn(in);

        assertThat(inputview.inputBonusNum()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("당첨 번호")
    @ValueSource(strings = {"1,2,3,4,5,6"})
    public void inputWinningNum(String input){
        InputStream in = getInput(input);
        System.setIn(in);

        assertThat(inputview.inputWinningNum()).isEqualTo(List.of(1,2,3,4,5,6));
    }
}