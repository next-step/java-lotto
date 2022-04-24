import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlusTest {

    @Test
    void 입력값이_널이거나_비어있는_경우_예외_발생() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    String input = "";
                    new Input(input);
                });

        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    String input = null;
                    new Input(input);
                });
    }

    @Test
    void 문자열_덧셈() {
        Plus plus = new Plus();
        Assertions.assertThat(plus.sum(1, 3)).isEqualTo(4);
    }

}
