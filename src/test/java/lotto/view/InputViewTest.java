package lotto.view;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class InputViewTest {

    @ParameterizedTest(name = "구매 금액은 1000의 단위로 나누어 떨어지는 정수 값이 아닌 경우 예외가 발생한다.")
    @ValueSource(strings = {"-1000", "14500", "abc"})
    public void invalidPurchasePriceInputTest(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        InputView inputView = InputView.of(inputStream);
        assertThatIllegalArgumentException()
                .isThrownBy(inputView::getPurchaseAmount)
                .withMessageContaining(input);
    }

}