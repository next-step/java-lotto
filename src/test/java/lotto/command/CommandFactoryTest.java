package lotto.command;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CommandFactoryTest {

    @DisplayName("더하기에 해당하는 연산자를 가져온다")
    @Test
    void get_add_command() {
        Assertions.assertThat(new CommandFactory().getCommand("+"))
                  .isInstanceOf(AddCommand.class);
    }

    @Test
    void get_minus_command() {

    }
}

