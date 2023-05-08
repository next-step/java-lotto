package step1;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step1.domain.num.Num;
import step1.domain.num.Nums;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumTest {

    @ParameterizedTest(name = "num객체 만들기")
    @ValueSource(strings = "2 + 3 * 4 / 2")
    void 문자열로_숫자_객체_생성(String input) {
        String[] inputs = input.split(" ");
        Num num = new Num(inputs[0]);

        assertThat(num).isEqualTo(new Num("2"));
    }

    @ParameterizedTest(name = "num객체 만들기 타입 에러")
    @ValueSource(strings = "2 + 3 * 4 / 2")
    void 문자열로_숫자_객체_생성_예외(String input) {
        String[] inputs = input.split(" ");
        assertThatThrownBy(() -> new Num(inputs[1]))
                .isInstanceOf(NumberFormatException.class)
                .hasMessage("숫자를 입력해주세요.");
    }

    @ParameterizedTest(name = "nums객체 값 체크")
    @ValueSource(strings = "2 + 3 * 4 / 2")
    void 숫자_리스트_객체_값_체크(String input) {
        String[] inputs = input.split(" ");
        Nums nums = new Nums(new Num(inputs[0]), new Num(inputs[2]));
        assertThat(nums.firstNum()).isEqualTo(new Num(2));
        assertThat(nums.secondNum()).isEqualTo(new Num(3));
    }
}
