package stringcaculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class NumberTest {
    @ParameterizedTest
    @ValueSource(strings = {"0", "198", "98765434"})
    @DisplayName("Number의 객체 생성이 정상적으로 되고 값이 같으면 같은 객체인지 확인한다.")
    void legalParameter(String value) {
        assertThat(new Number(new StringToIntegerValue(value)).equals(new Number(new StringToIntegerValue(value)))).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "19^8", "-10000"})
    @DisplayName("Number 객체 생성시 비정상적인 값이 주입되면 IllegalParameterException을 발생히시키는지 확인합니다.")
    void illegalParameter(String value) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> {new Number(new StringToIntegerValue(value));}
        );
    }
}