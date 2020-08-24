package step1;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class UserInputTest {
    @Test
    void validateUserInputTest(){

        String input = "";
        assertThatThrownBy(()->{
            new ValidateInput(input);
        }).isInstanceOf(IllegalArgumentException.class);

    }
}
