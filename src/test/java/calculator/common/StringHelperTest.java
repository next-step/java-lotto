package calculator.common;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringHelperTest {
    @Test
    public void 문자열을_받아서_디폴트_구분자로_구분하고_그_원소를_확인한다() {
        //given
        StringHelper stringHelper = new StringHelper();
        //when
        String[] elements = stringHelper.split("1:2:3");
        //then
        assertThat(elements).containsExactly("1", "2", "3");
    }
}
