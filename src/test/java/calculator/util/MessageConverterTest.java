package calculator.util;

import calculator.domain.InputValue;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by seungwoo.song on 2022-10-04
 */
class MessageConverterTest {

    @Test
    void convert() {
        MessageConverter messageConverter = new MessageConverter();
        List<InputValue> inputValues = messageConverter.convert("2 +  3 ");

        assertThat(inputValues).hasSize(3);
        assertThat(inputValues.get(0)).isEqualTo(new InputValue("2"));
        assertThat(inputValues.get(1)).isEqualTo(new InputValue("+"));
        assertThat(inputValues.get(2)).isEqualTo(new InputValue("3"));
    }
}