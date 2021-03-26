package lotto.step2;

import lotto.step2.domain.Lotto;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @ParameterizedTest(name = "illegalArgumentExceptionTest")
    @MethodSource("illegalArrayProvider")
    public void illegalArgumentExceptionTest(String[] input) {
        assertThatThrownBy(() -> new Lotto(input) )
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> illegalArrayProvider() {
        return Stream.of(
                Arguments.of((Object) new String[]{"1","4","5","7","3"}),
                Arguments.of((Object) new String[]{"1","4","5","7","3","0"})
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
