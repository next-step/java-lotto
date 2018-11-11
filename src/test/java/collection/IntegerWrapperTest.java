package collection;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegerWrapperTest {
    @Test
    public void 숫자1로_변환() {
        IntegerWrapper integerWrapper = new IntegerWrapper("1");
        assertThat(integerWrapper.getValue()).isEqualTo(1);
    }

    @Test(expected = RuntimeException.class)
    public void 음수_에러() {
        IntegerWrapper integerWrapper = new IntegerWrapper("-10");
    }

    @Test(expected = RuntimeException.class)
    public void 숫자말고문자_에러() {
        IntegerWrapper integerWrapper = new IntegerWrapper("a");
    }
}
