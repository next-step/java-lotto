import calculator.model.Application;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class ApplicationTest {

    Application application = new Application();

    @ParameterizedTest
    @DisplayName("잘못된 식 예외")
    @ValueSource(strings = {
            "",
            "1 + 2 / / 3",
            "-1",
            "1 + 2 /" ,
            "- 1 / 3" ,
            "2 & 3"
    })
    void 잘못된_수식(String string){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->{
                    application.calculate(string);
                });
    }

    @Test
    @DisplayName("더하기 테스트")
    void 더하기_테스트(){
        String string = "1 + 2 + 5";

        int res = application.calculate(string);

        assertThat(res).isEqualTo(8);
    }

    @Test
    @DisplayName("빼기 테스트")
    void 빼기_테스트(){
        String string = "12-5";

        int res = application.calculate(string);

        assertThat(res).isEqualTo(7);
    }

    @Test
    @DisplayName("나눗셈 테스트")
    void 나눗셈_테스트(){
        String string = "12/2";
        int res = application.calculate(string);

        assertThat(res).isEqualTo(6);
    }

    @Test
    @DisplayName("0으로 나눌때 예외 테스트")
    void 나눗셈_예외_테스트(){
        String string = "1 + 2 / 0";
        assertThatIllegalArgumentException().isThrownBy(()->{
            application.calculate(string);
        });
    }

    @Test
    @DisplayName("곱셈 테스트")
    void 곱셈_테스트(){
        String string = "12 * 2";

        int res = application.calculate(string);

        assertThat(res).isEqualTo(24);
    }


    @DisplayName("성공하는 수식")
    @ParameterizedTest(name = "{0} = {1}")
    @CsvSource(value = {
            "1 - 1 * 2 + 2 = 2",
            "1 + 5 / 2 - 1 * 2 = 4",
            "12 * 2 = 24",
            "12/2 = 6"
    }, delimiter = '=')
    void calculate(String expression, int expected) {
        assertThat(application.calculate(expression)).isEqualTo(expected);
    }
}
