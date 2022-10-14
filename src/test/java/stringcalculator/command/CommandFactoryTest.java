package stringcalculator.command;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CommandFactoryTest {

    @DisplayName("더하기에 해당하는 연산자를 가져온다")
    @Test
    void get_add_command() {
        assertThat(new CommandFactory().getCommand("+"))
                  .isInstanceOf(AddCommand.class);
    }

    @DisplayName("뺄셈에 해당하는 연산자를 가져온다")
    @Test
    void get_minus_command() {
        assertThat(new CommandFactory().getCommand("-")).isInstanceOf(MinusCommand.class);
    }

    @DisplayName("곱셈에 해당하는 연산자를 가져온다")
    @Test
    void get_multiply_command() {
        assertThat(new CommandFactory().getCommand("*")).isInstanceOf(MultiplyCommand.class);
    }

    @DisplayName("나눗셈에 해당하는 연산자를 가져온다")
    @Test
    void get_divide_command() {
        assertThat(new CommandFactory().getCommand("/")).isInstanceOf(DivideCommand.class);
    }

}

