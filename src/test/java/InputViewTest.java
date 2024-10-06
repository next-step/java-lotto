import org.assertj.core.api.Assertions;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import view.InputView;

public class InputViewTest {
    @Test
    @DisplayName("콤마 기준으로 split 테스트")
    void splitTest(){
        //given
        final String testInput = "2 + 3 * 4 / 2";
        //when
        String[] split = InputView.splitByEmptyString(testInput);
        //then
        Assertions.assertThat(split).contains("2","+","3","*","4","/","2");
    }
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 ^ 4 / 2","2 $ 3 ^ 4 @ 2"})
    void splitTest_NotArithmeticCharacters(String testInput){
        //given

        //when
        ThrowableAssert.ThrowingCallable callable = () -> InputView.splitByEmptyString(testInput);

        //then
        Assertions.assertThatThrownBy(callable)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
    @DisplayName("입력 값이 빈 공백 문자일 경우 IllegalArgumentException throw")
    void splitTest_EmptyString(String input){
        //given

        //when
        ThrowableAssert.ThrowingCallable callable = () -> InputView.splitByEmptyString(input);

        //then
        Assertions.assertThatThrownBy(callable)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력 값이 null일 경우 IllegalArgumentException throw")
    void splitTest_Null(){
        //given

        //when
        ThrowableAssert.ThrowingCallable callable = () -> InputView.splitByEmptyString(null);

        //then
        Assertions.assertThatThrownBy(callable)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
