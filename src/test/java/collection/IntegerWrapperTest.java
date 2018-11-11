package collection;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class IntegerWrapperTest {

    @Test
    public void 양의_정수가져오기() {
        IntegerWrapper integerWrapper = new IntegerWrapper("1");
        assertThat(integerWrapper.getValue()).isEqualTo(1);
    }

    @Test(expected = RuntimeException.class)
    public void 음수_넣을때() {
        IntegerWrapper integerWrapper = new IntegerWrapper("-1");
    }

}
