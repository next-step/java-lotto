package step2.model;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PaymentTest {

    @DisplayName("금액 생성 오류 테스트")
    @ParameterizedTest
    @MethodSource("createPaymentExceptionTestCases")
    public void createPaymentExceptionTest(int money) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> Payment.of(money))
            .withMessageContaining("금액은 0 이상의 값으로 입력해주세요.");
    }

    private static Stream<Arguments> createPaymentExceptionTestCases() {
        return Stream.of(
            Arguments.of(0),
            Arguments.of(-1000)
        );
    }
}