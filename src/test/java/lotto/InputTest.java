package lotto;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.mock.FakePrinter;
import lotto.mock.FakeReader;
import lotto.view.InputView;
import lotto.view.printer.Printer;
import lotto.view.reader.Reader;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputTest {
    private Printer printer = new FakePrinter();


    @DisplayName("정상적이지 않은 입력에 대해서 예외를 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "2two", "2147483648", "-2147483649", "-1", "0", "1", "1001"})
    void validateInput(String input) {
        // given
        Reader reader = new FakeReader(input);
        InputView inputView = InputView.of(reader, printer);

        assertThatIllegalArgumentException().isThrownBy(inputView::inputPurchaseAmount);
    }
}
