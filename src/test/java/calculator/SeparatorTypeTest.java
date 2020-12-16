package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SeparatorTypeTest {

    @Test
    void findByInputText() {
        SeparatorType separatorType = SeparatorType.findByInputText(new InputText("1,2:3"));
        assertThat(separatorType).isEqualTo(SeparatorType.DEFAULT);

        separatorType = SeparatorType.findByInputText(new InputText("//;\n1;2;3"));
        assertThat(separatorType).isEqualTo(SeparatorType.CUSTOM);
    }

}
