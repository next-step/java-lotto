import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class InputTest {

    @Test
    void isEmpty_when_null() {
        // given
        Input stringInput = new Input((String) null);
        Input expectedInput = new Input(new String[] { null });

        // expect
        assertThat(stringInput).isEqualTo(expectedInput);
    }

    @Test
    void isEmpty_when_blank() {
        // given
        String input = "  ";
        Input stringInput = new Input(input);
        Input expectedInput = new Input(new String[] { "  " });

        // expect
        assertThat(stringInput).isEqualTo(expectedInput);
    }

    @Test
    void createInput_with_custom_delimiter() {
        // given
        String input = "//;\n1;2;3";
        Input expectedInput = new Input("1", "2", "3");

        // when
        Input stringInput = new Input(input);

        // then
        assertThat(stringInput).isEqualTo(expectedInput);
    }

    @Test
    void createInput_with_no_custom_delimiter() {
        // given
        String input = "1,2:3";
        Input expectedInput = new Input("1", "2", "3");

        // when
        Input stringInput = new Input(input);

        // then
        assertThat(stringInput).isEqualTo(expectedInput);
    }

}