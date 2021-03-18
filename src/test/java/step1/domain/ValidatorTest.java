package step1.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ValidatorTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        this.validator = new Validator();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1,1;true",
            "1,2,3,4;true",
            "2,6,3,9;true",
            "1:3;true",
            "1+3;false",
            "1/0;false"}, delimiter = ';')
    @DisplayName("인풋이 올바른지 아닌지 구분할 수 있다")
    void canValidateInput(String input, boolean expected) {
        assertThat(validator.isInputMadeOfValidElements(input)).isEqualTo(expected);
    }
}