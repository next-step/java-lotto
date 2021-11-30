package lotto;

import lotto.view.InputView;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class InputViewTest {

    @Test
    void inputPrice() {

        InputView inputView = new InputView();

        String input = "123000";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        inputView.getTicket();
    }
}
