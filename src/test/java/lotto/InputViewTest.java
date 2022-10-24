package lotto;

import lotto.input.TicketPriceInput;
import lotto.view.InputView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

public class InputViewTest {

    @BeforeEach
    void setOutStream(){
        OutputStream out= new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    @DisplayName("InputView를 통해 TicketPriceInput 받아오는지 확인")
    void testIfGetTicketPriceInput(){
        String priceInput = "14000";
        InputStream in1 = new ByteArrayInputStream(priceInput.getBytes());
        System.setIn(in1);

        InputView inputView = new InputView();
        TicketPriceInput result = inputView.getTicketPriceInput();

        TicketPriceInput expected = TicketPriceInput.builder()
                .priceInput(14000)
                .ticketAmt(14)
                .build();
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("InputView를 통해 WinningNumbersInput 받아오는지 확인")
    void testIfGetWinningNumbersInput(){
        String winningNumbersString = "1, 2, 3, 4, 5, 6";
        InputStream in1 = new ByteArrayInputStream(winningNumbersString.getBytes());
        System.setIn(in1);

        InputView inputView = new InputView();
        String result = inputView.getWinningNumbers();

        String expected = "1, 2, 3, 4, 5, 6";
        assertThat(result).isEqualTo(expected);
    }
}
