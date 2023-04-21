package calculator.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class ClientInputTest {

    private static final String CLIENT_TEST_DATA = "1 + 2 * 3 / 4"; 
    
    @Test
    @DisplayName("값을 입력했을 경우 객체를 생성한다.")
    void clientInputSuccessTest() {
        ClientInput clientInput = new ClientInput(CLIENT_TEST_DATA);
        assertThat(clientInput).isNotNull();
    }

    @ParameterizedTest(name = "[{index}] 빈값 입력시 익셉션이 발생한다.")
    @NullAndEmptySource
    void clientInputEmptyTest(String emptyValue) {
        assertThatThrownBy(() -> new ClientInput(emptyValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("값이 입력되지 않았습니다.");
    }
}
