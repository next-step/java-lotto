import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AdditionTest {

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
    void 덧셈() {
        Addition addition = new Addition();
        Assertions.assertThat(addition.sum(1, 3)).isEqualTo(4);
    }
}
