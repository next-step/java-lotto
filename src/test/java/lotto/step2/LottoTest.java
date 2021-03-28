package lotto.step2;

import lotto.step2.domain.Lotto;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @ParameterizedTest(name = "로또_숫자_개수_Test")
    @MethodSource("로또_숫자_개수_Provider")
    public void 로또_숫자_개수_Test(String[] input) {
        assertThatThrownBy(() -> new Lotto(input) )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또는 6개의 서로 다른 숫자로 만들어져야 합니다");
    }

    static Stream<Arguments> 로또_숫자_개수_Provider() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1","4","5","7","3"}),
                Arguments.of((Object) new String[]{"1","4","5","7","3","5"}),
                Arguments.of((Object) new String[]{"1","4","5","7","3","13","9"})
        );
    }


    @ParameterizedTest(name = "로또_숫자_범위_Test")
    @MethodSource("로또_숫자_범위_Provider")
    public void 로또_숫자_범위_Test(String[] input) {
        assertThatThrownBy(() -> new Lotto(input) )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효범위를 벗어난 숫자입니다.");
    }

    static Stream<Arguments> 로또_숫자_범위_Provider() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1","4","5","7","-3","33"}),
                Arguments.of((Object) new String[]{"1","4","5","7","0","5"}),
                Arguments.of((Object) new String[]{"1","4","5","46","3","13"})
        );
    }

    @ParameterizedTest(name = "로또_숫자_타입_Test")
    @MethodSource("로또_숫자_타입_Provider")
    public void 로또_숫자_타입_Test(String[] input) {
        assertThatThrownBy(() -> new Lotto(input) )
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또번호는 정수여야 합니다.");
    }

    static Stream<Arguments> 로또_숫자_타입_Provider() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1","4","5","7","3","a"}),
                Arguments.of((Object) new String[]{"1","4","5","7","나","5"}),
                Arguments.of((Object) new String[]{"1","4","5","1a","3","13"})
        );
    }
    

    @ParameterizedTest(name = "creationTest")
    @MethodSource("arrayProvider")
    public void creationTest(String[] input, Lotto inputLotto) {
        assertThat(new Lotto(input).equals(inputLotto));
    }

    static Stream<Arguments> arrayProvider() {
        return Stream.of(
                Arguments.of((Object)new String[]{"4","6","13","32","42","45"},(Object) new Lotto(new String[]{"4","6","13","32","42","45"}))
        );
    }

}
