package calculator.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


public class StringUtilTest {

    @Test
    public void checkNullTest(){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new StringUtil().checkNullOrEmpty(null);
        });
    }

    @ParameterizedTest
    @ValueSource(strings={""})
    public void checkEmptyTest(String input){
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new StringUtil().checkNullOrEmpty(input);
        });
    }



}
