package calculator.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class ClientResponseTest {

    private static final String CLIENT_TEST_DATA = "1 + 2 * 3 / 4 - 5";

    private static final String SINGLE_NUMBER_INPUT = "1";

    @Test
    @DisplayName("값을 입력했을 경우 객체를 생성한다.")
    void clientInputSuccessTest() {
        ClientResponse clientResponse = new ClientResponse(CLIENT_TEST_DATA);
        assertThat(clientResponse).isNotNull();
    }

    @ParameterizedTest(name = "[{index}] 빈값 입력시 익셉션이 발생한다.")
    @NullAndEmptySource
    void clientInputEmptyTest(String emptyValue) {
        assertThatThrownBy(() -> new ClientResponse(emptyValue))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("값이 입력되지 않았습니다.");
    }

    @Test
    @DisplayName("사용자 입력값에서 숫자만 포함한 배열을 리턴한다.")
    void numberReturnTest() {
        ClientResponse clientResponse = new ClientResponse(CLIENT_TEST_DATA);
        assertThat(clientResponse.getNumbers()).containsExactly(1, 2, 3, 4, 5);
    }

    @Test
    @DisplayName("사용자 입력값에 단일 숫자 입력 했을 경우 단일 숫자 배열을 리턴한다.")
    void singleNumberReturnTest() {
        ClientResponse clientResponse = new ClientResponse(SINGLE_NUMBER_INPUT);
        assertThat(clientResponse.getNumbers()).containsExactly(1);
    }

    @Test
    @DisplayName("사용자 입력값에서 연산기호만 포함한 배열을 리턴한다")
    void returnSymbolsTest() {
        ClientResponse clientResponse = new ClientResponse(CLIENT_TEST_DATA);
        assertThat(clientResponse.getSymbols()).containsExactly("+", "*", "/", "-");
    }

    @Test
    @DisplayName("사용자 입력값에 단일 숫자만 입력된 경우 연산기호는 빈 배열을 리턴한다")
    void returnSingleSymbolsTest() {
        ClientResponse clientResponse = new ClientResponse(SINGLE_NUMBER_INPUT);
        assertThat(clientResponse.getSymbols()).isEmpty();
    }
}
