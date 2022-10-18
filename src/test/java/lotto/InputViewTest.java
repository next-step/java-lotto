package lotto;

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
    @DisplayName("InputView를 통해 ClientInput 받아오는지 확인")
    void testIfGetClientInput(){
        String priceInput = "14000";
        InputStream in1 = new ByteArrayInputStream(priceInput.getBytes());
        System.setIn(in1);

        InputView inputView = new InputView();
        ClientInput result = inputView.getClientInput();

        ClientInput expected = ClientInput.builder()
                .priceInput(14000)
                .ticketAmt(14)
                .build();
        assertThat(result).isEqualTo(expected);
    }
}
