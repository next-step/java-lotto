package collection;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositiveNumberTest {

    @Test
    public void 양의_정수가져오기() {
        PositiveNumber positiveNumber = new PositiveNumber("1");
        assertThat(positiveNumber.getValue()).isEqualTo(1);
    }

    @Test(expected = RuntimeException.class)
    public void 음수_넣을때() {
        PositiveNumber positiveNumber = new PositiveNumber("-1");
    }

}
