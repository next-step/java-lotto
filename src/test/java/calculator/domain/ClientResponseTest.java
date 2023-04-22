package calculator.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class ClientResponseTest {

    private static final String CLIENT_TEST_DATA = "1 + 2 * 3 / 4";

    private static final int MINIMUM_EVEN_NUMBER = 2;

    private static final int TO_ROUND = 1;

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
    @DisplayName("\"1 2\"을 ,로 split 했을 때 1과 2 를 분리한다")
    void splitTestStep1() {
        final String[] result = "1 2".split(" ");
        assertThat(result).contains("1", "2");
        assertThat(result).containsExactly("1", "2");
    }

    @ParameterizedTest(name = "홀수를 2로 나눈 값을 반 내림 하여 반환한다. ex) {0} / 2 -> {1}")
    @CsvSource(value = {"7:3", "1:0"}, delimiter = ':')
    void oddNumberReturnTest(int numerator, int expect) {
        assertThat(numerator / MINIMUM_EVEN_NUMBER).isEqualTo(expect);
    }

    @ParameterizedTest(name = "홀수를 2로 나눈 값을 반 올림 하여 반환한다. ex) {0} / 2 -> {1}")
    @CsvSource(value = {"7:4", "1:1"}, delimiter = ':')
    void evenNumberReturnTest(int numerator, int expect) {
        assertThat((numerator / MINIMUM_EVEN_NUMBER) + TO_ROUND).isEqualTo(expect);
    }

    @Test
    @DisplayName("사용자 입력값에서 숫자만 포함한 배열을 리턴한다.")
    void numberReturnTest() {
        ClientResponse clientResponse = new ClientResponse(CLIENT_TEST_DATA);
        assertThat(clientResponse.getNumbers()).containsExactly("1","2","3","4");
    }

    @Test
    @DisplayName("사용자 입력값에 단일 숫자 입력 했을 경우 단일 숫자 배열을 리턴한다.")
    void singleNumberReturnTest() {
        ClientResponse clientResponse = new ClientResponse("1");
        assertThat(clientResponse.getNumbers()).containsExactly("1");
    }
}
