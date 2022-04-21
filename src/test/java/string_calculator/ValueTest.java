package string_calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValueTest {
    @Test
    void create() {
        assertThat(new Integer(1)).isInstanceOf(Integer.class);
        assertThat(new Operator("*")).isInstanceOf(Operator.class);
    }

    @ParameterizedTest
//    @CsvSource(value = {"!:false", "@:false", "#:false", "$:false", "%:true", "^:true", "&:false", "*:true", "-:true", "+:true"}, delimiter = ':')
    @ValueSource(strings = {"!", "@", "#", "$", "^", "&"})
    void wrongArgs(String input) {
        assertThatThrownBy(() -> new Operator(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
