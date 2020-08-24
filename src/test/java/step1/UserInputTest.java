package step1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class UserInputTest {

    @Test
    void validateUserInputTest(){

        String input = "-3";
        assertThatThrownBy(()->{
            new ValidateInput(input);
        }).isInstanceOf(RuntimeException.class);

    }

    @Test
    @NullAndEmptySource
    void validateInputNUll(String input){
//        ValidateInput
    }

}
