package calculator.util;

import calculator.domain.Input;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by seungwoo.song on 2022-10-05
 */
class MessageConverterTest {

    @Test
    void 변화() {
        List<Input> inputs = MessageConverter.convert("2 + 3");
        assertThat(inputs)
                .hasSize(3)
                .containsExactly(new Input("2"), new Input("+"), new Input("3"));
    }
}